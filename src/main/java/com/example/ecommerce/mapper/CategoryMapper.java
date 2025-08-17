package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CategoryResponse;
import com.example.ecommerce.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getCode(), category.getTitle(), category.getImg(), category.getRating(), category.getGender());
    }
}
