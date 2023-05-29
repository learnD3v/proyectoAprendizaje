package com.hora.delusuario.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "envio")
@Getter
@Setter
public class EnvioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_envio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "contacto_entrega")
    private String contactoEntrega;

    // Otros atributos relacionados con los envíos

    // Constructor, getters y setters, etc.
}

