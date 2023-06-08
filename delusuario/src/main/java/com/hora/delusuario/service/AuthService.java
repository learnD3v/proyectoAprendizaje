package com.hora.delusuario.service;

import com.hora.delusuario.model.UserEntity;

public interface AuthService {
    String authenticateAndGenerateToken(String correo, String contrasenha);

    UserEntity getUserByCorreo(String correo);

    // ...
}

