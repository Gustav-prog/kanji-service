package com.example.kanjiservice.auth;

import com.example.kanjiservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ApplicationUser implements UserDetails {

    private User user;
    private List<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser(User user) {
        this.user = user;
        this.grantedAuthorities = populateGrantedAuthorities(this.user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public Long getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUserDetails() {
        return user;
    }


    public static List<GrantedAuthority> populateGrantedAuthorities(User user) {
        List<GrantedAuthority> grantedAuthorities = user.getUserRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().getRoleName())).collect(Collectors.toList());
        return grantedAuthorities;
    }
}