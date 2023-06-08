package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.model.LoginRequest;
import com.hora.delusuario.model.LoginResponse;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.HistorialInicioRepository;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.service.AuthService;
import com.hora.delusuario.service.HistorialInicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String correo = loginRequest.getCorreo();
        String contrasenha = loginRequest.getContrasenha();

        // Realizar la autenticación del usuario y generar el token
        String token = authService.authenticateAndGenerateToken(correo, contrasenha);

        if (token != null) {
            // Si la autenticación es exitosa, devolver el token en la respuesta
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);

            return ResponseEntity.ok(loginResponse);
        } else {
            // Si la autenticación falla, devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    // Otros métodos del controlador...

    // ...

}


