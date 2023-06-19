package com.hora.delusuario.service;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CambioContrasenhaService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void generarTokenResetContrasenha(String correo) {
        UserEntity user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + correo);
        }

        // Generar un token temporal para el reinicio de contraseña
        String tokenReset = generateResetToken();

        // Establecer el token en el usuario
        user.setTokenReset(tokenReset);

        // Guardar el usuario actualizado en la base de datos
        userRepository.save(user);

        // Aquí puedes enviar el token por correo electrónico al usuario para que lo utilice en el proceso de reinicio de contraseña
    }

    public String generateResetToken() {
        String tokenReset = UUIDUtil.generateUUID();
        return tokenReset;
    }

    public void cambiarContrasenhaConTokenReset(String tokenReset, String nuevaContrasenha) {
        UserEntity user = userRepository.findByTokenReset(tokenReset);
        if (user == null) {
            throw new IllegalArgumentException("Token de reinicio de contraseña no válido");
        }

        // Encriptar la nueva contraseña
        String encryptedPassword = passwordEncoder.encode(nuevaContrasenha);

        // Establecer la nueva contraseña en el usuario
        user.setContrasenha(encryptedPassword);

        // Borrar el token de reinicio
        user.setTokenReset(null);

        // Guardar el usuario actualizado en la base de datos
        userRepository.save(user);
    }
}