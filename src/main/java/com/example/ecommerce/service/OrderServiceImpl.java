package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderProductsRequest;
import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.dto.OrderResponse;
import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.mapper.OrderMapper;
import com.example.ecommerce.repository.AddressRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toResponse).toList();
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!"));

        Address address = addressRepository.findById(orderRequest.addressId()).orElseThrow(() -> new RuntimeException("Address not found"));

        List<Long> productIds = orderRequest.products().stream().map(OrderProductsRequest::productId).toList();
        List<Product> products = productRepository.findAllById(productIds);

        Order order = orderRepository.save(orderMapper.toEntity(orderRequest, user, address, products));
        return orderMapper.toResponse(orderRepository.save(order));
    }
}
