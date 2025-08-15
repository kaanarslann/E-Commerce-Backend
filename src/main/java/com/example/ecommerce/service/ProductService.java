package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductFilterRequest;
import com.example.ecommerce.dto.ProductListResponse;
import com.example.ecommerce.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductListResponse getProducts();
    ProductListResponse getFilteredProducts(ProductFilterRequest productFilterRequest);
    ProductResponse getProductById(Long id);
}
