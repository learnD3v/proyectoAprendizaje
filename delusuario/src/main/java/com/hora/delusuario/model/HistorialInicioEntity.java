package com.hora.delusuario.model;

import com.hora.delusuario.model.convertidoresfecha.TimestampToLocalTime;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "historial_inicio")
public class HistorialInicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private Long idSesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UserEntity usuario;

    @Column(name = "token")
    private String token;

    @Column(name = "fecha_inicio")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fechaInicio;

    // Resto de los atributos y métodos de la entidad

    // Setter y getter para idSesion
    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    // Setter y getter para usuario
    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    // Setter y getter para token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Setter y getter para fechaInicio
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}