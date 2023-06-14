package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.service.HistorialInicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/historial-inicio")
public class HistorialInicioController {

    private final HistorialInicioService historialInicioService;

    public HistorialInicioController(HistorialInicioService historialInicioService) {
        this.historialInicioService = historialInicioService;
    }

    @GetMapping("/ordenado")
    public List<Object[]> obtenerHistorialInicioOrdenado() {
        return historialInicioService.obtenerHistorialInicioOrdenado();
    }

}
