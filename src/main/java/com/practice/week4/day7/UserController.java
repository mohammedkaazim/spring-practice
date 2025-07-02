package com.practice.week4.day7;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String userApi(HttpServletRequest request) {
        String role = (String) request.getAttribute("role");
        if ("USER".equals(role) || "ADMIN".equals(role)) {
            return "Welcome User, Profile Access Granted.";
        }
        return "Access Denied.";
    }
}
