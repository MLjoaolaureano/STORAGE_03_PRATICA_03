package com.example.demo.controller;

import com.example.demo.model.TestCase;
import com.example.demo.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/testcases/")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;


    @PostMapping("new")
    ResponseEntity<TestCase> create(@RequestBody TestCase testCase) {
        TestCase testCaseResponse = testCaseService.create(testCase);

        return (new ResponseEntity(testCaseResponse, HttpStatus.CREATED));
    }

    @GetMapping
    ResponseEntity<List<TestCase>> list() {
        List<TestCase> testCaseListResponse = testCaseService.listAll();

        return (new ResponseEntity(testCaseListResponse, HttpStatus.FOUND));
    }

    @GetMapping("/{id}")
    ResponseEntity<List<TestCase>> getById(@PathVariable("id") Long idTestCase) {
        TestCase testCaseResponse = testCaseService.findById(idTestCase);

        return (new ResponseEntity(testCaseResponse, HttpStatus.FOUND));
    }

    @PutMapping("/{id}")
    ResponseEntity<TestCase> update(@PathVariable("id") int idTestCase, @RequestBody TestCase testCase) {
        TestCase testCaseUpdateResponse = testCaseService.update(idTestCase, testCase);

        return (new ResponseEntity(testCaseUpdateResponse, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> remove(@PathVariable("id") long idTestCase) {
        Boolean deleteResponse = testCaseService.remove(idTestCase);

        return (new ResponseEntity(null, HttpStatus.NO_CONTENT));
    }

    @GetMapping("/testing")
    ResponseEntity<List<TestCase>> getByLastUpdated(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date last_update) {
        List<TestCase> testCaseListResponse = testCaseService.findByLastUpdatedAfter(last_update);

        return (new ResponseEntity(testCaseListResponse, HttpStatus.FOUND));
    }
}
