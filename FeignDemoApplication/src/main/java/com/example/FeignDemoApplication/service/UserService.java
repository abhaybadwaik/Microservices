package com.example.FeignDemoApplication.service;

import com.example.FeignDemoApplication.FeignClient.FeignClientService;
import com.example.FeignDemoApplication.FeignClient.JsonPlaceHolderClient;
import com.example.FeignDemoApplication.model.People;
import com.example.FeignDemoApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JsonPlaceHolderClient client;
    @Autowired
    FeignClientService feignClientService;

    public User fetchUser(long id){
        return client.getUser(id);
    }
    public List<User> fetchAllUser(){
        return client.getAllUsers();
    }
    public ResponseEntity<List<People>> getAllPeople(){
        return feignClientService.getAll();
    }
}
