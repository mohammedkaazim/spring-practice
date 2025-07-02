package com.practice.week4.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {

        Map<String, String> tokens = new HashMap<>();

        if ("admin".equals(username) && "password".equals(password)) {
            tokens.put("accessToken", jwtUtil.generateAccessToken(username, "ADMIN"));
            tokens.put("refreshToken", jwtUtil.generateRefreshToken(username));
        } else if ("user".equals(username) && "password".equals(password)) {
            tokens.put("accessToken", jwtUtil.generateAccessToken(username, "USER"));
            tokens.put("refreshToken", jwtUtil.generateRefreshToken(username));
        } else {
            tokens.put("error", "Invalid credentials");
        }

        return tokens;
    }

    @PostMapping("/refresh")
    public String refresh(@RequestParam String refreshToken) {
        if (jwtUtil.isTokenValid(refreshToken)) {
            String username = jwtUtil.extractUsername(refreshToken);
            return jwtUtil.generateAccessToken(username, "USER");
        }
        return "Invalid Refresh Token";
    }

    @PostMapping("/logout")
    public String logout() {
        // Frontend should delete token, backend is stateless
        return "Logout successful. Please delete tokens from client side.";
    }
}
