package com.hora.delusuario.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "cliente")
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(name = "nombre", length = 100)
    @NotNull
    private String nombre;

    @Column(name = "numero_contacto", length = 25)
    private String numero_contacto;

    @Column(name = "numero_ruc", length = 60)
    @NotNull
    private String numero_ruc;

    // Otros atributos y métodos del modelo

    // Constructor, getters y setters, etc.
}

