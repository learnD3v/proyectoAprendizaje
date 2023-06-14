package com.hora.delusuario.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
@CrossOrigin("http://localhost:4200/")
public class HistorialInicioDTO {
    private Long idSesion;
    private String correo;
    private LocalDate fechaInicio;

    // Constructor, getters y setters

    // Constructor vacío
    public HistorialInicioDTO() {
    }

    // Constructor con parámetros
    public HistorialInicioDTO(Long idSesion, String correo, LocalDate fechaInicio) {
        this.idSesion = idSesion;
        this.correo = correo;
        this.fechaInicio = fechaInicio;
    }

    // Getters y setters
    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
