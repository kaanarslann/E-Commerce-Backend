package com.example.ecommerce.dto;

public record AddressResponse(Long id, String title, String name, String surname, String phone, Long userId, String city, String district, String neighborhood, String address) {
}
