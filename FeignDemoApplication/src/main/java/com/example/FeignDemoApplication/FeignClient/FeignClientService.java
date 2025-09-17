package com.example.FeignDemoApplication.FeignClient;

import com.example.FeignDemoApplication.model.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "FeignClientService"
)
public interface FeignClientService {
    @GetMapping("/people/getAllPeople")
    ResponseEntity<List<People>> getAll();
}
