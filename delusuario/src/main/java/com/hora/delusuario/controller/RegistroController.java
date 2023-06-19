package com.hora.delusuario.controller;

import com.hora.delusuario.model.RegistroRequest;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistroController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistroRequest registroRequest) {
        // Validar los datos de registro
        // ...

        // Crear un nuevo usuario utilizando el servicio de CustomUserDetailsService
        UserEntity newUser = userDetailsService.createUser(registroRequest);

        return ResponseEntity.ok("Registro exitoso");
    }
}