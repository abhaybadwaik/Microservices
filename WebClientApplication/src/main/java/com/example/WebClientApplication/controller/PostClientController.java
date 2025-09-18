package com.example.WebClientApplication.controller;

import com.example.WebClientApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/client/posts")
public class PostClientController {
    @Autowired
    PostService postService;

    @GetMapping
    public Flux<Object> getPosts(){
        return postService.getAllPosts();
    }
    @PostMapping
    public Mono<Object> createPost(@RequestBody Map<String,Object> postRequest){
        return postService.createPost(postRequest);
    }
}
