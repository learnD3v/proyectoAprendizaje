package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.service.HistorialInicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial-inicio")
public class HistorialInicioController {

    private final HistorialInicioService historialInicioService;

    public HistorialInicioController(HistorialInicioService historialInicioService) {
        this.historialInicioService = historialInicioService;
    }

    @PostMapping
    public ResponseEntity<?> guardarHistorialInicio(@RequestBody HistorialInicioEntity historialInicio) {
        historialInicioService.guardarHistorialInicio(historialInicio);
        return ResponseEntity.ok("Historial de inicio guardado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialInicioEntity> obtenerHistorialInicioPorId(@PathVariable Long id) {
        HistorialInicioEntity historialInicio = historialInicioService.obtenerHistorialInicioPorId(id);
        return ResponseEntity.ok(historialInicio);
    }

    @GetMapping("/ver")
    public ResponseEntity<List<HistorialInicioEntity>> obtenerTodosLosHistorialesInicio() {
        List<HistorialInicioEntity> historialesInicio = historialInicioService.obtenerTodosLosHistorialesInicio();
        return ResponseEntity.ok(historialesInicio);
    }

    // Otros métodos según tus necesidades

    // ...

}
