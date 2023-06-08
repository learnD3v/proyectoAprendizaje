package com.hora.delusuario.service;

import com.hora.delusuario.model.RolesEntity;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.RolesRepository;
import com.hora.delusuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByCorreo(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Construye una lista de GrantedAuthority en base al rol del usuario
        List<GrantedAuthority> authorities = buildAuthorities(user.getRol());

        return new CustomUserDetails(user.getCorreo(), user.getContrasenha(), authorities);
    }

    private List<GrantedAuthority> buildAuthorities(RolesEntity rol) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (rol == null) {
            throw new IllegalArgumentException("Rol inválido");
        }

        String roleName = rol.getTipoRol();
        authorities.add(new SimpleGrantedAuthority(roleName));

        return authorities;
    }
}