package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductFilterRequest;
import com.example.ecommerce.dto.ProductListResponse;
import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public ProductListResponse getFilteredProducts(@RequestParam(required = false) String filter,
                                                   @RequestParam(required = false) Long categoryId,
                                                   @RequestParam(required = false) String sort,
                                                   @RequestParam(required = false, defaultValue = "asc") String direction,
                                                   @RequestParam(defaultValue = "24") Integer limit,
                                                   @RequestParam(defaultValue = "0") Integer offset) {
        ProductFilterRequest request = new ProductFilterRequest(filter, categoryId, sort, direction, limit, offset);
        return productService.getFilteredProducts(request);
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@Positive @PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
