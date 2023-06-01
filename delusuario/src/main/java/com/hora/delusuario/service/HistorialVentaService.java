package com.hora.delusuario.service;

import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.repository.HistorialVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class HistorialVentaService {

    private final HistorialVentaRepository historialVentaRepository;

    public HistorialVentaService(HistorialVentaRepository historialVentaRepository) {
        this.historialVentaRepository = historialVentaRepository;
    }

    public List<HistorialVentaEntity> obtenerTodosLosHistorialesVenta() {
        return historialVentaRepository.findAll();
    }

    // Otros métodos del servicio según tus necesidades
}