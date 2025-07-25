package com.practice.week2.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello from Spring Boot REST API!";
    }
}
