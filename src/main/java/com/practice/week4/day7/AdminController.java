package com.practice.week4.day7;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminApi(HttpServletRequest request) {
        String role = (String) request.getAttribute("role");
        if ("ADMIN".equals(role)) {
            return "Welcome ADMIN, You have full access.";
        }
        return "Access Denied.";
    }
}
