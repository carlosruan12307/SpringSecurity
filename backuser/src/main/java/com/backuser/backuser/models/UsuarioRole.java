package com.backuser.backuser.models;

import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import com.backuser.backuser.enums.RoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class UsuarioRole implements GrantedAuthority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRole;
    @Enumerated(EnumType.STRING)
    private RoleEnum nome;
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nome.toString();
    }
}
