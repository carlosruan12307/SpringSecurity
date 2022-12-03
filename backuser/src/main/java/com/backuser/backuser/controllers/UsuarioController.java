package com.backuser.backuser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backuser.backuser.models.UsuarioModel;
import com.backuser.backuser.models.UsuarioRole;
import com.backuser.backuser.response.UsuarioResponse;
import com.backuser.backuser.services.UsuarioService;

import lombok.Data;

@RestController
@Data
public class UsuarioController {
    @Autowired
    private UsuarioService us;
    @Autowired
    
    @PreAuthorize("hasHole('ROLE_ADMIN')")
    @GetMapping("/")
    public String inicio(){
        return "bem vindo a api de usuarios";
    }
    @GetMapping("/listarUsuarios")
    public List<UsuarioModel> listarUsuarios(){
        return us.listarUsuarios();
    }

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return us.cadastrarUsuario(usuario);
    }

    @PostMapping("/cadastrarRole")
    public ResponseEntity<UsuarioResponse> cadastrarRole(@RequestBody UsuarioRole role){
        return us.cadastrarRole(role);
    }
}
