package com.example.ecommerce.service;

import com.example.ecommerce.dto.RoleResponse;
import com.example.ecommerce.mapper.RoleMapper;
import com.example.ecommerce.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getRoles() {
        return roleRepository.findAll().stream().map(roleMapper::toResponse).toList();
    }
}
