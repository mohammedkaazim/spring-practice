package com.practice.week3.day7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public ResponseEntity<ApiResponse<User>> addUser(@Valid @RequestBody UserDTO userDTO) {

        User user = new User((int)(Math.random()*1000), userDTO.getName(), userDTO.getAge());
        userRepository.save(user);

        ApiResponse<User> response = new ApiResponse<>("User saved successfully", user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>("User fetched successfully", user.get()));
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
    }
}
