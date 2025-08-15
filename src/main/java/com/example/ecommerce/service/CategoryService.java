package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories();
}
