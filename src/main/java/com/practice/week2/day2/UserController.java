package com.practice.week2.day2;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/api/user")
    public String createUser(@RequestBody User user){
        return "User created: " + user.getName() + ", Age: " + user.getAge();
    }
}
