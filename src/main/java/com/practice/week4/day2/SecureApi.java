package com.practice.week4.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecureApi {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/secure")
    public String securedApi(@RequestHeader("Authorization") String token) {

        token = token.replace("Bearer ", "");

        try {
            String username = jwtUtil.validateToken(token);
            return "Welcome " + username + ", this is a secured API.";
        } catch (Exception e) {
            return "Invalid or expired token.";
        }
    }
}
