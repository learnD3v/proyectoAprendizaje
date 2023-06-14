package com.hora.delusuario.controller;

import com.hora.delusuario.model.EnvioEntity;
import com.hora.delusuario.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/envios")
public class EnvioController {
    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping
    public ResponseEntity<EnvioEntity> crearEnvio(@RequestBody EnvioEntity envio) {
        EnvioEntity nuevoEnvio = envioService.crearEnvio(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEnvio);
    }

    @GetMapping("/{idEnvio}")
    public ResponseEntity<EnvioEntity> obtenerEnvio(@PathVariable Long idEnvio) {
        EnvioEntity envio = envioService.obtenerEnvio(idEnvio);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idEnvio}")
    public ResponseEntity<Void> actualizarEnvio(@PathVariable Long idEnvio, @RequestBody EnvioEntity envio) {
        EnvioEntity envioExistente = envioService.obtenerEnvio(idEnvio);
        if (envioExistente != null) {
            envio.setId_envio(idEnvio);
            envioService.actualizarEnvio(envio);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEnvio}")
    public ResponseEntity<Void> eliminarEnvio(@PathVariable Long idEnvio) {
        EnvioEntity envioExistente = envioService.obtenerEnvio(idEnvio);
        if (envioExistente != null) {
            envioService.eliminarEnvio(idEnvio);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
