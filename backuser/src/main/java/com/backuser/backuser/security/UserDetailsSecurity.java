package com.backuser.backuser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backuser.backuser.models.UsuarioModel;
import com.backuser.backuser.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsSecurity implements UserDetailsService {

    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = ur.findBynome(username).orElseThrow(() -> new UsernameNotFoundException("usuario" + username + "nao encontrado"));
        return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());

    }
    
}
