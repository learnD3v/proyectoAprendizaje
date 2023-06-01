package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "producto")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_id_producto_seq", allocationSize = 1)
    private Integer id_producto;

    @Column(name = "nombre_producto")
    @NotNull
    private String nombre_producto;

    @Column(name = "cantidad")
    @NotNull
    private Integer cantidad;

    @Column(name = "precio_producto")
    @NotNull
    private Double precio_producto;

    public Integer getId() {
        return id_producto;
    }
}

