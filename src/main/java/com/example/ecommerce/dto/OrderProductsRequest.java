package com.example.ecommerce.dto;

public record OrderProductsRequest(
        Long productId,
        Integer count,
        String detail
) {
}
