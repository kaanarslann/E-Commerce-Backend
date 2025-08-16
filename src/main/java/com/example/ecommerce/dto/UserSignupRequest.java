package com.example.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserSignupRequest(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        Long roleId,
        String storeName,
        String storePhone,
        String storeTaxId,
        String storeBankAccount
) {
}
