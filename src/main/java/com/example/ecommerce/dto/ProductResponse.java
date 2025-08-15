package com.example.ecommerce.dto;

import java.util.List;

public record ProductResponse(Long id, String name, String description, Long categoryId, Double price, Double rating, Integer sellCount, Integer stock, Long storeId, List<ProductImagesResponse> images) {
}
