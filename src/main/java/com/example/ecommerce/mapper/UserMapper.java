package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.UserResponse;
import com.example.ecommerce.dto.UserSignupRequest;
import com.example.ecommerce.entity.User;

public class UserMapper {
    public User toEntity(UserSignupRequest signupRequest) {
        User user = new User();
        user.setFullName(signupRequest.name());
        user.setEmail(signupRequest.email());
        user.setPassword(signupRequest.password());
        if(signupRequest.storeName() != null)
            user.setStoreName(signupRequest.storeName());
        if(signupRequest.storePhone() != null)
            user.setStorePhone(signupRequest.storePhone());
        if(signupRequest.storeTaxId() != null)
            user.setStoreTaxId(signupRequest.storeTaxId());
        if(signupRequest.storeBankAccount() != null)
            user.setStoreBankAccount(signupRequest.storeBankAccount());

        return user;
    }
}
