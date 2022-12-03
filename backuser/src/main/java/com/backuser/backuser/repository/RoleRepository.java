package com.backuser.backuser.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backuser.backuser.models.UsuarioRole;

@Repository
public interface RoleRepository extends JpaRepository<UsuarioRole,UUID>{
    
}
