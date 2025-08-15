package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;

import java.util.List;

public interface CreditCardService {
    List<CreditCardResponse> getCreditCards();
    CreditCardResponse save(CreditCardRequest creditCardRequest);
    CreditCardResponse update(Long id, CreditCardRequest creditCardRequest);
    void delete(Long id);
}
