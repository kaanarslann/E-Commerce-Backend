package com.example.ecommerce.dto;

public record ProductFilterRequest(
        String filter,
        Long categoryId,
        String sort,
        String direction,
        Integer limit,
        Integer offset
) {
}
