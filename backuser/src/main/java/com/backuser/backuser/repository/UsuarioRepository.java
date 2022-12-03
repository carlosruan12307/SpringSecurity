package com.backuser.backuser.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backuser.backuser.models.UsuarioModel;

import lombok.Data;

@Repository

public interface UsuarioRepository extends JpaRepository<UsuarioModel,UUID> {
    
    Optional<UsuarioModel> findBynome(String name);
}
