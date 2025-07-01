package com.practice.week2.day5;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> userList = new ArrayList<>();

    // GET - List all users
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userList;
    }

    // POST - Create new user
    @PostMapping("/api/users")
    public String addUser(@RequestBody User user) {
        userList.add(user);
        return "User added successfully.";
    }

    // PUT - Update existing user by ID
    @PutMapping("/api/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setAge(updatedUser.getAge());
                return "User updated successfully.";
            }
        }
        return "User not found.";
    }

    // DELETE - Delete user by ID
    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
                return "User deleted successfully.";
            }
        }
        return "User not found.";
    }
}
