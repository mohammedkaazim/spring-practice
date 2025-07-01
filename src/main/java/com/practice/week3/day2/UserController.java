package com.practice.week3.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public String addUser(@Valid @RequestBody UserDTO userDTO) {

        // DTO se Entity me data set karna
        User user = new User();
        user.setId((int)(Math.random()*1000)); // Random id demo ke liye
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());

        userRepository.save(user);

        return "User saved with DTO: " + user.getName();
    }
}
