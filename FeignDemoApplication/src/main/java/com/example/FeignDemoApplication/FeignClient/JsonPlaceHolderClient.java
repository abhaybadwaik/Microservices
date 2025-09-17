package com.example.FeignDemoApplication.FeignClient;

import com.example.FeignDemoApplication.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name= "jsonPlaceHolder",
        url= "https://jsonplaceholder.typicode.com"
)
public interface JsonPlaceHolderClient {

    @GetMapping("/users/{id}")
    User getUser(@PathVariable("id")Long id);

    @GetMapping("/users")
    List<User> getAllUsers();
}
