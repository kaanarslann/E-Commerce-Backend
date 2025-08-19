package com.example.ecommerce.service;

import com.example.ecommerce.dto.BackendResponse;
import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.UserResponse;
import com.example.ecommerce.dto.UserSignupRequest;

public interface UserService {
    UserResponse getByEmail(String email);
    BackendResponse save(UserSignupRequest signupRequest);
    UserResponse verify(String token);
    UserResponse login(LoginRequest loginRequest);
}
