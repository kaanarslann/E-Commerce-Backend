package com.example.ecommerce.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ECommerceException extends RuntimeException{
    private HttpStatus httpStatus;

    public ECommerceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
