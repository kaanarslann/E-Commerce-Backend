package com.example.ecommerce.dto;

import java.util.List;

public record ProductListResponse(List<ProductResponse> products, Long total) {
}
