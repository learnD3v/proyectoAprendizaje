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
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> crearUsuario(@RequestBody UserEntity userEntity) {
        userEntity.setFechaRegistro(LocalDateTime.now());

        try {
            UserEntity nuevoUsuario = userService.crearUsuario(userEntity);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

