package com.practice.week3.day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public String addUser(@Valid @RequestBody UserDTO userDTO) {

        User user = new User();
        user.setId((int)(Math.random()*1000));
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());

        userRepository.save(user);

        return "User saved successfully.";
    }
}
