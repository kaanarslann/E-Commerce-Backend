package com.example.ecommerce.controller;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;
import com.example.ecommerce.service.AddressService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private final AddressService addressService;

    @GetMapping("/address")
    public List<AddressResponse> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping("/address")
    public AddressResponse save(@Validated @RequestBody AddressRequest addressRequest) {
        return addressService.save(addressRequest);
    }

    @PutMapping("/address")
    public AddressResponse update(@Positive Long id, @Validated @RequestBody AddressRequest addressRequest) {
        return addressService.update(id, addressRequest);
    }

    @DeleteMapping("/address/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable("id") Long id) {
        addressService.delete(id);
    }
}
