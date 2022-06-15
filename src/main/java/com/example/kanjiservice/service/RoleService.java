package com.example.kanjiservice.service;

import com.example.kanjiservice.auth.ApplicationUserRole;
import com.example.kanjiservice.entity.Role;
import com.example.kanjiservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByRoleName(ApplicationUserRole role) {
        return roleRepository.findByRoleName("ROLE_" + role);
    }
}