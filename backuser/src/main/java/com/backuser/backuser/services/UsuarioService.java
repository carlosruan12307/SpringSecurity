package com.backuser.backuser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backuser.backuser.models.UsuarioModel;
import com.backuser.backuser.models.UsuarioRole;
import com.backuser.backuser.repository.RoleRepository;
import com.backuser.backuser.repository.UsuarioRepository;
import com.backuser.backuser.response.UsuarioResponse;

import lombok.Data;

@Service
@Data
public class UsuarioService {

    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private UsuarioResponse r;
    @Autowired
    private RoleRepository rr;
    
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(UsuarioModel usuario){
            ur.save(usuario);
            
            r.setMensagem("usuario cadastrado com sucesso");
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.OK);
    }

    public List<UsuarioModel> listarUsuarios(){
        return ur.findAll();
    }
    public ResponseEntity<UsuarioResponse> cadastrarRole(UsuarioRole role){
            rr.save(role);
            r.setMensagem("role cadastrado com sucesso");
            return new ResponseEntity<UsuarioResponse>(r, HttpStatus.OK);
    }
}
