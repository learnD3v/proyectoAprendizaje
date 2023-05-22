package com.hora.delusuario.service;

public interface AuthService {
    String authenticateAndGenerateToken(String correo, String contrasenha);

    // ...
}

