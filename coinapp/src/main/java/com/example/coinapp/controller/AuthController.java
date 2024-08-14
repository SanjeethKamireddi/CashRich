package com.example.coinapp.controller;

import com.example.coinapp.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDTO userDTO) {
        // Handle user signup logic
        return "User signed up successfully";
    }

    @PostMapping("/login")
    public String login() {
        // Handle user login logic
        return "User logged in successfully";
    }
}
