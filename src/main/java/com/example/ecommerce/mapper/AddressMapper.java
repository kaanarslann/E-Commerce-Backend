package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;
import com.example.ecommerce.entity.Address;

public class AddressMapper {

    public Address toEntity(AddressRequest addressRequest) {
        Address address = new Address();
        address.setTitle(addressRequest.title());
        address.setName(addressRequest.name());
        address.setSurname(addressRequest.surname());
        address.setCity(addressRequest.city());
        address.setDistrict(addressRequest.district());
        address.setNeighborhood(addressRequest.neighborhood());
        address.setAddress(addressRequest.address());

        return address;
    }

    public AddressResponse toResponse(Address address) {
        return new AddressResponse(address.getId(), address.getTitle(), address.getName(), address.getSurname(), address.getPhone(),address.getUser().getId(),address.getCity(), address.getDistrict(), address.getNeighborhood(), address.getAddress());
    }
}
