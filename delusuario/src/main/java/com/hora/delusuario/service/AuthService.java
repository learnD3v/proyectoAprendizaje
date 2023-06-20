package com.hora.delusuario.service;

import com.hora.delusuario.model.AuthenticationRequest;
import com.hora.delusuario.model.AuthenticationResponse;
import com.hora.delusuario.model.UserEntity;

public interface AuthService {
    AuthenticationResponse authenticateAndGenerateToken(AuthenticationRequest request);

    UserEntity getUserByCorreo(String correo);

    // ...
}

