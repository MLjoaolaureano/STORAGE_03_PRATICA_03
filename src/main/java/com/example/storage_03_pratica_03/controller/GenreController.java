package com.example.storage_03_pratica_03.controller;

import com.example.storage_03_pratica_03.model.Genre;
import com.example.storage_03_pratica_03.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genre/")
public class GenreController {

    @Autowired
    GenreService genreService;


    @PostMapping("new")
    ResponseEntity<Genre> create(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Genre genre) {
        Genre genreResponse = genreService.create(genre);

        return (new ResponseEntity(genreResponse, HttpStatus.CREATED));
    }

    @GetMapping
    ResponseEntity<List<Genre>> list() {
        List<Genre> genreListResponse = genreService.listAll();

        return (new ResponseEntity(genreListResponse, HttpStatus.FOUND));
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Genre>> getById(@PathVariable("id") int idGenre) {
        Genre genreResponse = genreService.getById(idGenre);

        return (new ResponseEntity(genreResponse, HttpStatus.FOUND));
    }

//    @PutMapping("/{id}")
//    ResponseEntity<Actor> update(@PathVariable("id") int idTestCase, @RequestBody Actor testCase) {
//        Actor testCaseUpdateResponse = actorService.update(idTestCase, testCase);
//
//        return (new ResponseEntity(testCaseUpdateResponse, HttpStatus.OK));
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> remove(@PathVariable("id") int idGenre) {
        Boolean deleteResponse = genreService.remove(idGenre);

        return (new ResponseEntity(null, HttpStatus.NO_CONTENT));
    }

}
