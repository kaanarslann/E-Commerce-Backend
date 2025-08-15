package com.example.ecommerce.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreditCardRequest(
        @NotNull
        Integer cardNo,

        @NotNull
        Integer expireMonth,

        @NotNull
        Integer expireYear,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 50)
        String nameOnCard
) {
}
