package com.practice.week4.day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        if ("admin".equals(username) && "password".equals(password)) {
            return jwtUtil.generateToken(username, "ADMIN");
        } else if ("user".equals(username) && "password".equals(password)) {
            return jwtUtil.generateToken(username, "USER");
        }
        return "Invalid credentials";
    }
}
