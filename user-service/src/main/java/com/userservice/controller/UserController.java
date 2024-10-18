package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationDto registrationDto) {
        // Implement user registration logic (e.g., saving to the database)
        // Hash the password with passwordEncoder before saving
        String hashedPassword = passwordEncoder.encode(registrationDto.getPassword());
        // Save hashedPassword along with other user info to the database
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLoginDto loginDto) {
        // Implement user authentication logic (e.g., checking credentials in the database)
        // If credentials are valid, generate and return a JWT
        String jwt = jwtTokenProvider.generateToken(loginDto.getUsername());
        return jwt;
    }
}
