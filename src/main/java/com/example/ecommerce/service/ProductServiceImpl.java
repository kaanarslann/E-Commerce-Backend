package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductFilterRequest;
import com.example.ecommerce.dto.ProductListResponse;
import com.example.ecommerce.dto.ProductResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Override
    public ProductListResponse getProducts() {
        Pageable pageable = PageRequest.of(0, 24, Sort.by(Sort.Direction.ASC, "id"));

        Page<Product> page = productRepository.findAll(pageable);

        List<ProductResponse> productResponses = page.getContent().stream().map(productMapper::toResponse).toList();

        return new ProductListResponse(productResponses, page.getTotalElements());
    }

    @Override
    public ProductListResponse getFilteredProducts(ProductFilterRequest request) {
        Sort.Direction direction = Sort.Direction.fromString(request.direction() != null ? request.direction() : "ASC");
        Sort sort = Sort.by(direction, request.sort() != null ? request.sort() : "id");

        Pageable pageable = PageRequest.of(
                request.offset() != null ? request.offset() : 0,
                request.limit() != null ? request.limit() : 24,
                sort
        );

        Page<Product> page = productRepository.findFilteredProducts(request.categoryId(), request.filter(), pageable);

        List<ProductResponse> productResponses = page.getContent().stream().map(productMapper::toResponse).toList();

        return new ProductListResponse(productResponses, page.getTotalElements());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productMapper.toResponse(productOptional.get());
        }
        return null;
    }
}
