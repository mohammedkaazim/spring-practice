package com.practice.week4.day6;

import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SecureApi {

    @GetMapping("/secure")
    public String securedApi(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        String role = (String) request.getAttribute("role");
        return "Welcome " + username + ", Your role: " + role;
    }
}
