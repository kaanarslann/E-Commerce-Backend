package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;
import com.example.ecommerce.dto.AddressUpdateRequest;
import com.example.ecommerce.dto.BackendResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddresses();
    AddressResponse save(AddressRequest addressRequest);
    AddressResponse update(AddressUpdateRequest updateRequest);
    BackendResponse delete(Long id);
}
