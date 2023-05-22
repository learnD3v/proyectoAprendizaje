package com.hora.delusuario.controller;

import com.hora.delusuario.model.LoginRequest;
import com.hora.delusuario.model.LoginResponse;
import com.hora.delusuario.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Realizar la autenticación del usuario y generar el token
        String token = authService.authenticateAndGenerateToken(loginRequest.getCorreo(), loginRequest.getContrasenha());

        if (token != null) {
            // Si la autenticación es exitosa, devolver el token en la respuesta
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            String message = loginResponse.getMessage();
            return ResponseEntity.ok(loginResponse);
        } else {
            // Si la autenticación falla, devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

// Otros métodos del controlador...

// ...
}