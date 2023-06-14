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
    private Long id_sesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UserEntity id_usuario;

    @Column(name = "token")
    private String token;

    @Column(name = "fecha_inicio")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fecha_inicio;

    // Resto de los atributos y métodos de la entidad

    // Setter y getter para idSesion
    public Long getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(Long idSesion) {
        this.id_sesion = idSesion;
    }

    // Setter y getter para usuario
    public UserEntity getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UserEntity usuario) {
        this.id_usuario = usuario;
    }

    // Setter y getter para token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Setter y getter para fechaInicio
    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fechaInicio) {
        this.fecha_inicio = fechaInicio;
    }
}