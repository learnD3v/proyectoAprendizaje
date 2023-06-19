package com.hora.delusuario.service;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void changePassword(String username, String currentPassword, String newPassword) {
        UserEntity user = userRepository.findByCorreo(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        if (!passwordEncoder.matches(currentPassword, user.getContrasenha())) {
            throw new IllegalArgumentException("Contraseña actual incorrecta");
        }

        String encryptedPassword = passwordEncoder.encode(newPassword);
        user.setContrasenha(encryptedPassword);
        userRepository.save(user);
    }
}

