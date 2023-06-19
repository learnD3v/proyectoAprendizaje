package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.service.HistorialInicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    public List<LinkedHashMap<String, Object>> obtenerHistorialInicioOrdenado() {
        List<Object[]> resultados = historialInicioService.obtenerHistorialInicioOrdenado();

        List<LinkedHashMap<String, Object>> historialesInicio = new ArrayList<>();
        for (Object[] fila : resultados) {
            LinkedHashMap<String, Object> historialInicio = new LinkedHashMap<>();
            historialInicio.put("Codigo", fila[0]);
            historialInicio.put("Correo", fila[1]);
            historialInicio.put("Fecha", fila[2]);
            historialesInicio.add(historialInicio);
        }

        return historialesInicio;
    }

    }
