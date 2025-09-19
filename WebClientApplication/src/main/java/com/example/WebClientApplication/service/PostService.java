package com.example.WebClientApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    //    GEt External APi
    public Flux<Object> getAllPosts() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Client Error: " + response.statusCode())))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Server Error: " + response.statusCode())))
                .bodyToFlux(Object.class);
    }
    public Mono<Object> getPostById(int id) {
        return webClient.get()
                .uri("/posts/{id}", id)  // forward the id to external API
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Client Error: " + response.statusCode())))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Server Error: " + response.statusCode())))
                .bodyToMono(Object.class);
    }

    public Mono<Object> createPost(Object postRequest) {
        return webClient.post()
                .uri("/posts")
                .bodyValue(postRequest)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Invalid Request: " + response.statusCode())))
                .onStatus(HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Server Unavailable: " + response.statusCode()))
                ).bodyToMono(Object.class);
    }
}