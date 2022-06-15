package com.example.kanjiservice.service;

import com.example.kanjiservice.entity.Role;
import com.example.kanjiservice.entity.User;
import com.example.kanjiservice.entity.UserRole;
import com.example.kanjiservice.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole create(Role role, User user) {

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }
}