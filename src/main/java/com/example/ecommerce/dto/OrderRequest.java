package com.example.ecommerce.dto;

import com.example.ecommerce.entity.OrderProducts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(
        @NotNull
        Long addressId,

        @NotNull
        Integer cardNo,

        @NotNull
        Integer cardExpireMonth,

        @NotNull
        Integer cardExpireYear,

        @NotNull
        @NotEmpty
        @NotBlank
        @Size(max = 50)
        String cardName,

        @NotNull
        Double price,

        List<OrderProductsRequest> products,

        LocalDateTime orderDate
) {
}
