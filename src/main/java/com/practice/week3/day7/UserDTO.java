package com.practice.week3.day7;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public UserDTO() {}

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
}
