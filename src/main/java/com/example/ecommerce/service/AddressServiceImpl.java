package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddressRequest;
import com.example.ecommerce.dto.AddressResponse;
import com.example.ecommerce.dto.AddressUpdateRequest;
import com.example.ecommerce.dto.BackendResponse;
import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exceptions.AddressNotFoundException;
import com.example.ecommerce.exceptions.EntityNotFoundException;
import com.example.ecommerce.mapper.AddressMapper;
import com.example.ecommerce.repository.AddressRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressResponse> getAddresses() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return addressRepository.findByUserId(user.getId()).stream().map(addressMapper::toResponse).toList();
    }

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found."));

        Address address = addressMapper.toEntity(addressRequest);
        address.setUser(user);
        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public AddressResponse update(AddressUpdateRequest updateRequest) {
        Address existingAddress = addressRepository.findById(updateRequest.id()).orElseThrow(() -> new AddressNotFoundException("Address not found."));
        Address address = addressMapper.toEntity(updateRequest);
        address.setCreatedAt(existingAddress.getCreatedAt());
        address.setUser(existingAddress.getUser());
        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public BackendResponse delete(Long id) {
        if(!addressRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Address not found.");
        }
        addressRepository.deleteById(id);
        return new BackendResponse("Record deleted successfully!");
    }
}
