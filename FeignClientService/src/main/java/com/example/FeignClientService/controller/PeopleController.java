package com.example.FeignClientService.controller;

import com.example.FeignClientService.model.People;
import com.example.FeignClientService.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @PostMapping("/register")
    public ResponseEntity<People> register(@RequestBody People people){
        return new ResponseEntity<>(peopleService.registerPeople(people), HttpStatus.OK);
    }
    @GetMapping("/getAllPeople")
    public ResponseEntity<List<People>> getAll(){
        return new ResponseEntity<>(peopleService.getPeople(),HttpStatus.OK);
    }
}
