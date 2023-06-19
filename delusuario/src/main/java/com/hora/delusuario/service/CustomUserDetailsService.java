package com.hora.delusuario.service;

import com.hora.delusuario.model.RegistroRequest;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity createUser(RegistroRequest registroRequest) {
        // Validar los datos de registro (por ejemplo, comprobar si el correo electrónico ya está registrado)
        // ...

        // Crear un nuevo objeto UserEntity y establecer los valores
        UserEntity newUser = new UserEntity();
        newUser.setNombre(registroRequest.getNombre());
        newUser.setCorreo(registroRequest.getCorreo());
        // Encriptar la contraseña
        String encryptedPassword = passwordEncoder.encode(registroRequest.getContrasenha());
        newUser.setContrasenha(encryptedPassword);

        newUser.setFechaRegistro(LocalDateTime.now());

        // Guardar el nuevo usuario en la base de datos
        return userRepository.save(newUser);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByCorreo(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Construye una lista de GrantedAuthority en base al rol del usuario
        List<GrantedAuthority> authorities = buildAuthorities(user.getRol());

        return new org.springframework.security.core.userdetails.User(
                user.getCorreo(),
                user.getContrasenha(),
                authorities
        );
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
    public String getRoleByUsername(String username) {
        UserEntity user = userRepository.findByCorreo(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        RolesEntity role = user.getRol();
        if (role == null) {
            throw new IllegalStateException("El usuario no tiene asignado un rol");
        }

        return role.getTipoRol();
    }
}



