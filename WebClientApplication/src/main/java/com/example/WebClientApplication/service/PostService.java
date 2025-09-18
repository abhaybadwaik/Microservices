package com.example.WebClientApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    private final WebClient webClient;

    public PostService(WebClient webClient){
        this.webClient= webClient;
    }
//    GEt External APi
    public Flux<Object> getAllPosts(){
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Object.class);
    }
//    Post External ApI
    public Mono<Object> createPost(Object postRequest){
        return webClient.post()
                .uri("/posts")
                .bodyValue(postRequest)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
