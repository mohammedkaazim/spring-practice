package com.practice.week4.day4;

import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SecureApi {

    @GetMapping("/admin")
    public String adminApi(HttpServletRequest request) {
        String role = (String) request.getAttribute("role");
        if ("ADMIN".equals(role)) {
            return "Welcome ADMIN, secured Admin API.";
        }
        return "Access Denied. Only ADMIN can access.";
    }

    @GetMapping("/user")
    public String userApi(HttpServletRequest request) {
        String role = (String) request.getAttribute("role");
        if ("USER".equals(role) || "ADMIN".equals(role)) {
            return "Welcome User, secured User API.";
        }
        return "Access Denied.";
    }
}
