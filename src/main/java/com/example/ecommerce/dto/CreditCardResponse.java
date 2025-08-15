package com.example.ecommerce.dto;

public record CreditCardResponse(Long id, Integer cardNo, Integer expireMonth, Integer expireYear, String nameOnCard, Long userId) {
}
