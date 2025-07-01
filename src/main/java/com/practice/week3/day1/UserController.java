package com.practice.week3.day1;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/api/users")
    public String addUser(@Valid @RequestBody User user) {
        return "User created: " + user.getName() + ", Age: " + user.getAge();
    }
}
