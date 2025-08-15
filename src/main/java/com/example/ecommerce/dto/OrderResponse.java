package com.example.ecommerce.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(Long id, Long userId, Long addressId, Integer cardNo, Integer cardExpireMonth, Integer cardExpireYear, String cardName, Double price, LocalDateTime orderDate, List<OrderProductsResponse> products) {
}
