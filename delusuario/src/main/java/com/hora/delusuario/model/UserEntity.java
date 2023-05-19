package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private Integer IdUsuario;

    @Column(name = "nombre_completo")
    @NotNull
    private String Nombre;

    @Column(name = "correo")
    @NotNull
    private String Correo;

    @Column(name = "password")
    @NotNull
    private String Contrasenha;

    @Column(name = "fecha_registro")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime FechaRegi;
}

