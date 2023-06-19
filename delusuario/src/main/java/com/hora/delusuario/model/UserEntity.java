package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hora.delusuario.model.convertidoresfecha.TimestampToLocalTime;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity(name = "usuario")
@Setter
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "nombre_completo")
    @NotNull
    private String nombre;

    @Column(name = "correo")
    @NotNull
    private String correo;

    @Column(name = "password")
    @NotNull
    private String contrasenha;

    @Column(name = "fecha_registro")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    @JsonIgnore
    private RolesEntity rol;

    @Column(name = "token_reset")
    private String tokenReset;

    // Constructor, getters, and setters



    // Resto de los atributos y métodos de la entidad

    // Setter y getter para la relación con el rol
    public RolesEntity getRol() {
        return rol;
    }

    public void setRol(RolesEntity rol) {
        this.rol = rol;
    }

    // Resto de los setters y getters para los demás atributos

    public Integer getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.id_usuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getTokenReset() {
        return tokenReset;
    }

    public void setTokenReset(String tokenReset) {
        this.tokenReset = tokenReset;
    }
}



