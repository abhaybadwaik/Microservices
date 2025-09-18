package com.example.RestTemplete.Controller;

import com.example.RestTemplete.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public String getPost(@PathVariable int id) {
        return postService.getPost(id);
    }

    @PostMapping("/allPost")
    public String createPost() {
        return postService.createPost();
    }
}
