package com.hora.delusuario.controller;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api") // Especifica la ruta base ("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UserEntity> crearUsuario(@RequestBody UserEntity usuario) {
        usuario.setFechaRegi(LocalDateTime.now()); // Establecer la fecha y hora actual
        UserEntity nuevoUsuario = userService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
