package com.practice.week4.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public")
    public String publicApi() {
        return "This is a public API, no auth needed.";
    }

    @GetMapping("/private")
    public String privateApi() {
        return "This is a secured API, auth required.";
    }
}
