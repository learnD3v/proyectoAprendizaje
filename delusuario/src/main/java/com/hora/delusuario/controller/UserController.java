package com.hora.delusuario.controller;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @GetMapping("/{correo}")
    public UserEntity getUserByCorreo(@PathVariable String correo) {
        return userService.findByCorreo(correo);
    }
    @GetMapping("/usuarios")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}


