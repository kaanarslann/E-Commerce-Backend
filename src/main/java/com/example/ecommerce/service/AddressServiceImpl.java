package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;
import com.example.ecommerce.entity.Address;
import com.example.ecommerce.mapper.AddressMapper;
import com.example.ecommerce.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressResponse> getAddresses() {
        return addressRepository.findAll().stream().map(addressMapper::toResponse).toList();
    }

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        Address address = addressRepository.save(addressMapper.toEntity(addressRequest));
        return addressMapper.toResponse(address);
    }

    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) {
        Address address = addressMapper.toEntity(addressRequest);
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()) {
            address.setId(id);
            return addressMapper.toResponse(addressRepository.save(address));
        }
        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
