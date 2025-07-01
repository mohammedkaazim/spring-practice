package com.practice.week2.day7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create
    @PostMapping("/api/users")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User saved successfully.";
    }

    // Read All
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read by ID
    @GetMapping("/api/users/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    // Update
    @PutMapping("/api/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            userRepository.save(user);
            return "User updated successfully.";
        } else {
            return "User not found.";
        }
    }

    // Delete
    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "User deleted successfully.";
    }
}
