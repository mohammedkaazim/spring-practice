package com.practice.week2.day4;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @DeleteMapping("/api/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return "User with ID " + id + " has been deleted successfully.";
    }
}
