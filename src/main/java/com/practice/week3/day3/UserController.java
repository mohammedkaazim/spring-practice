package com.practice.week3.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User saved";
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
