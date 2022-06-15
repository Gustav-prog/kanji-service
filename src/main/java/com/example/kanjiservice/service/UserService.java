package com.example.kanjiservice.service;

import com.example.kanjiservice.auth.ApplicationUserRole;
import com.example.kanjiservice.entity.User;
import com.example.kanjiservice.model.request.UserRequest;
import com.example.kanjiservice.repository.UserRepository;
import com.example.kanjiservice.util.DateTimeUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleService userRoleService, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }


    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setEmail(userRequest.email());
        user.setCreatedAt(DateTimeUtil.now());
        userRepository.save(user);

        /*user.setUserRoles(Stream.of(
                        userRoleService.create(roleService.findByRoleName(ApplicationUserRole.ADMIN), user))
                .collect(Collectors.toList()));*/

        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException()); //TODO fix this
    }
}
