package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getOrders();
    OrderResponse save(OrderRequest orderRequest);
}
