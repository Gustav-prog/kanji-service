package com.example.kanjiservice.service;

import com.example.kanjiservice.auth.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true) //read about this, its opens the session
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ApplicationUser(userService.findByUsername(username));

    }

}