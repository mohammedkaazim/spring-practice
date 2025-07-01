package com.practice.week3.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            ApiResponse<User> response = new ApiResponse<>("User fetched successfully", user.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<User> response = new ApiResponse<>("User not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }
}
