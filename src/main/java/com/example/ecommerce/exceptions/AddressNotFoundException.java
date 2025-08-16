package com.example.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class AddressNotFoundException extends ECommerceException {
    public AddressNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
