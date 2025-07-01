package com.practice.week2.day3;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PutMapping("/api/user/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        return "User with ID" + id + " update to Name: " + user.getName() +
                ", Age: " + user.getAge();
    }
}
