package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddresses();
    AddressResponse save(AddressRequest addressRequest);
    AddressResponse update(Long id, AddressRequest addressRequest);
    void delete(Long id);
}
