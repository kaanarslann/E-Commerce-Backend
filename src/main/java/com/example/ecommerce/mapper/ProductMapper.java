package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductImagesResponse;
import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.entity.Product;

import java.util.List;

public class ProductMapper {
    public ProductResponse toResponse(Product product) {

        List<ProductImagesResponse> productImagesResponses = product.getImages().stream().map(image -> new ProductImagesResponse(image.getUrl(), image.getIndex())).toList();

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getCategory().getId(), product.getPrice(), product.getRating(), product.getSellCount(), product.getStock(), product.getStoreId(), productImagesResponses);
    }
}
