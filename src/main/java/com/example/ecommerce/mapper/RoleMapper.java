package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.RoleResponse;
import com.example.ecommerce.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponse toResponse(Role role) {
        return new RoleResponse(role.getId(), role.getName(), role.getCode());
    }
}
