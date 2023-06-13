package com.hora.delusuario.controller;

import java.time.LocalDateTime;

public class HistorialInicioDTO {
    private Long idSesion;
    private Long idUsuario;
    private String correo;
    private String nombreCompleto;
    private LocalDateTime fechaInicio;

    public HistorialInicioDTO(Long idSesion, Long idUsuario, String correo, String nombreCompleto, LocalDateTime fechaInicio) {
        this.idSesion = idSesion;
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
        this.fechaInicio = fechaInicio;
    }

    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
