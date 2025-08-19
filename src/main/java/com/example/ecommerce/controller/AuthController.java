package com.example.ecommerce.controller;

import com.example.ecommerce.dto.BackendResponse;
import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.UserResponse;
import com.example.ecommerce.dto.UserSignupRequest;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public BackendResponse signup(@Validated @RequestBody UserSignupRequest signupRequest) {
        return userService.save(signupRequest);
    }

    @PostMapping("/login")
    public UserResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @GetMapping("/verify")
    public UserResponse verify(@RequestHeader("Authorization") String token) {
        return userService.verify(token);
    }


}
