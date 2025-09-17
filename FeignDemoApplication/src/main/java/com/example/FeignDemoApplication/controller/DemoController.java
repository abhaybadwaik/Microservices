package com.example.FeignDemoApplication.controller;

import com.example.FeignDemoApplication.model.People;
import com.example.FeignDemoApplication.model.User;
import com.example.FeignDemoApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    UserService userService;
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id){
        return userService.fetchUser(id);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.fetchAllUser();
    }
    @GetMapping("/getAllPeople")
    public ResponseEntity<List<People>> getAllPeople(){
        return userService.getAllPeople();
    }
}
