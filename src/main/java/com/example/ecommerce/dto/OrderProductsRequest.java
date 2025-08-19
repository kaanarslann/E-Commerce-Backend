package com.example.ecommerce.dto;

public record OrderProductsRequest(
        Long product_id,
        Integer count,
        String detail
) {
}
