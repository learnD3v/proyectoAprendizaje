package com.hora.delusuario.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public String authenticateAndGenerateToken(String correo, String contrasenha) {
        // Verificar las credenciales del usuario y generar el token si son válidas
        UserEntity user = userRepository.findByCorreo(correo);

        if (user != null && verifyPassword(contrasenha, user.getContrasenha())) {
            // Autenticación exitosa, generar el token y devolverlo
            String token = generateToken(user);
            return token;
        } else {
            // Autenticación fallida
            return null;
        }
    }

    private String generateToken(UserEntity user) {
        String secretKey = "secreto fachero";
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String token = JWT.create()
                .withSubject(user.getIdUsuario().toString())  // Utiliza el ID del usuario como subject del token
                .sign(algorithm);

        return token;
    }


}
