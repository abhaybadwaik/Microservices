package com.example.RestTemplete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    private RestTemplate restTemplate;

    public String getPost(int id){
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        return restTemplate.getForObject(url, String.class);
    }
    public String createPost(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        Map<String,String> request = new HashMap<>();
        request.put("title","foo");
        request.put("body","bar");
        request.put("userID","1");

        return restTemplate.postForObject(url,request,String.class);
    }
}
