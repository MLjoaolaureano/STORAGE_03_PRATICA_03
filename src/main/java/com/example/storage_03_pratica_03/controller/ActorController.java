package com.example.storage_03_pratica_03.controller;

import com.example.storage_03_pratica_03.model.Actor;
import com.example.storage_03_pratica_03.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actor/")
public class ActorController {

    @Autowired
    ActorService actorService;


    @PostMapping("new")
    ResponseEntity<Actor> create(@RequestBody Actor actor) {
        Actor actorResponse = actorService.create(actor);

        return (new ResponseEntity(actorResponse, HttpStatus.CREATED));
    }

    @GetMapping
    ResponseEntity<List<Actor>> list() {
        List<Actor> testCaseListResponse = actorService.listAll();

        return (new ResponseEntity(testCaseListResponse, HttpStatus.FOUND));
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Actor>> getById(@PathVariable("id") int idActor) {
        Actor actorResponse = actorService.getById(idActor);

        return (new ResponseEntity(actorResponse, HttpStatus.FOUND));
    }

//    @PutMapping("/{id}")
//    ResponseEntity<Actor> update(@PathVariable("id") int idTestCase, @RequestBody Actor testCase) {
//        Actor testCaseUpdateResponse = actorService.update(idTestCase, testCase);
//
//        return (new ResponseEntity(testCaseUpdateResponse, HttpStatus.OK));
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> remove(@PathVariable("id") int idActor) {
        Boolean deleteResponse = actorService.remove(idActor);

        return (new ResponseEntity(null, HttpStatus.NO_CONTENT));
    }

}
