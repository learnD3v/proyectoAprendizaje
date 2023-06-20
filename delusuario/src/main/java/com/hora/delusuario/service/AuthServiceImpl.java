package com.hora.delusuario.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hora.delusuario.model.AuthenticationRequest;
import com.hora.delusuario.model.AuthenticationResponse;
import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final HistorialInicioService historialInicioService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, HistorialInicioService historialInicioService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.historialInicioService = historialInicioService;
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public AuthenticationResponse authenticateAndGenerateToken(AuthenticationRequest request) {
        // Verificar las credenciales del usuario y generar el token si son válidas
        UserEntity user = userRepository.findByCorreo(request.getCorreo());

        if (user != null && verifyPassword(request.getContrasenha(), user.getContrasenha())) {
            // Autenticación exitosa, generar el token y devolverlo
            String token = generateToken(user);

            // Crear instancia de HistorialInicioEntity
            HistorialInicioEntity historialInicio = new HistorialInicioEntity();
            historialInicio.setId_usuario(user);
            historialInicio.setToken(token);
            historialInicio.setFecha_inicio(LocalDateTime.now());

            // Guardar el historial de inicio de sesión en la base de datos
            historialInicioService.guardarHistorialInicio(historialInicio);

            // Crear instancia de AuthenticationResponse y devolverla
            Long idSesion = user.getIdUsuario().longValue(); // Conversión explícita de Integer a Long
            AuthenticationResponse response = new AuthenticationResponse(token, user.getNombre(), idSesion);
            return response;

        } else {
            // Autenticación fallida
            return null;
        }
    }

    @Override
    public UserEntity getUserByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
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



