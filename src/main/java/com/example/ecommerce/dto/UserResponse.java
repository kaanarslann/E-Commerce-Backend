package com.example.ecommerce.dto;

public record UserResponse(String token, String fullName, String email, Long roleId) {
}
