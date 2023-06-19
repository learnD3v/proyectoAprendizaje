package com.hora.delusuario.service;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.security.AuthenticationRequest;
import com.hora.delusuario.security.AuthenticationResponse;
import com.hora.delusuario.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Verificar si las credenciales son válidas
        UserEntity user = userRepository.findByCorreo(request.getCorreo());
        if (user == null || !user.getContrasenha().equals(request.getContrasenha())) {
            throw new AuthenticationException("Credenciales inválidas");
        }

        // Generar el token JWT
        String token = jwtUtil.generateToken(user.getCorreo(), user.getRol().getTipoRol());

        // Crear la respuesta de autenticación
        AuthenticationResponse response = new AuthenticationResponse(token, user.getCorreo());

        return response;
    }

    public class AuthenticationException extends RuntimeException {

        public AuthenticationException(String message) {
            super(message);
        }

        public AuthenticationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


