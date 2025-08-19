package com.example.ecommerce.dto;

public record UserResponse(String token, String name, String email, Long role_id) {
}
