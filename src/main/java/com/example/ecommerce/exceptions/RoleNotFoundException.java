package com.example.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends ECommerceException{
    public RoleNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
