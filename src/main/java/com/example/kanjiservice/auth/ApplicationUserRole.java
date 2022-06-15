package com.example.kanjiservice.auth;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.kanjiservice.auth.ApplicationUserPermission.ADMIN_READ;
import static com.example.kanjiservice.auth.ApplicationUserPermission.ADMIN_WRITE;
import static com.example.kanjiservice.auth.ApplicationUserPermission.STUDENT_READ;
import static com.example.kanjiservice.auth.ApplicationUserPermission.STUDENT_WRITE;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE)),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, ADMIN_READ, ADMIN_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));


        return permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    //method here get name with role prefix

}