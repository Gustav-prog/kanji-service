package com.example.kanjiservice.repository;

import com.example.kanjiservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long>  {

    Role findByRoleName(String s);
}
