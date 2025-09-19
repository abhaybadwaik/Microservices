package com.example.FeignDemoApplication.exceptions;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex){
        return ResponseEntity
                .status(ex.status())
                .body("Feign Client Error: " + ex.getMessage());
    }
    public ResponseEntity<String> handleNotFound(FeignException.NotFound ex){
        return ResponseEntity
                .status(404)
                .body("Resources not found in the feign client call");
    }
}
