package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.security.AuthenticationRequest;
import com.hora.delusuario.security.AuthenticationResponse;
import com.hora.delusuario.security.JwtUtil;
import com.hora.delusuario.service.CustomUserDetailsService;
import com.hora.delusuario.service.HistorialInicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@CrossOrigin("http://localhost:4200/")
@RestController
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private CustomUserDetailsService userDetailsService;
    private UserRepository userRepository;

    private HistorialInicioService historialInicioService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          CustomUserDetailsService userDetailsService, UserRepository userRepository, HistorialInicioService historialInicioService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.historialInicioService = historialInicioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            // Autenticar las credenciales del usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getCorreo(),
                            authenticationRequest.getContrasenha())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Credenciales de inicio de sesión inválidas", e);
        }

        // Obtener el rol del usuario autenticado (si lo necesitas)
        String rol = userDetailsService.getRoleByUsername(authenticationRequest.getCorreo());

        // Generar el token JWT
        String token = jwtUtil.generateToken(authenticationRequest.getCorreo(), rol);

        // Crear la respuesta de autenticación que incluye el token JWT
        AuthenticationResponse response = new AuthenticationResponse(token, authenticationRequest.getCorreo());

        // Guardar el registro en el historial de inicio de sesión
        HistorialInicioEntity historialInicio = new HistorialInicioEntity();
        historialInicio.setFecha_inicio(LocalDateTime.now());
        historialInicio.setId_usuario(userRepository.findByCorreo(authenticationRequest.getCorreo()));
        historialInicio.setToken(token);
        historialInicioService.guardarHistorialInicio(historialInicio);

        return ResponseEntity.ok(response);
    }
}


