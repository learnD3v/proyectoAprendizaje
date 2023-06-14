package com.hora.delusuario.service;

import com.hora.delusuario.controller.HistorialInicioDTO;
import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.HistorialInicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HistorialInicioService {

    private final HistorialInicioRepository historialInicioRepository;

    public HistorialInicioService(HistorialInicioRepository historialInicioRepository) {
        this.historialInicioRepository = historialInicioRepository;
    }

    public void guardarHistorialInicio(HistorialInicioEntity historialInicio) {
        historialInicioRepository.save(historialInicio);
    }

    public List<Object[]> obtenerHistorialInicioOrdenado() {
        return historialInicioRepository.obtenerHistorialInicioOrdenado();
    }
}



