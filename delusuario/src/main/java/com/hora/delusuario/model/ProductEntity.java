package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ingredientes")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @SequenceGenerator(name = "ingredient_seq", sequenceName = "ingredientes_id_ingrediente_seq", allocationSize = 1)
    private Integer id_ingrediente;

    @Column(name = "nombre_ingrediente")
    @NotNull
    private String nombre_ingrediente;

    @Column(name = "cantidad")
    @NotNull
    private Integer cantidad;

    @Column(name = "precio_ingredientes")
    @NotNull
    private Double precio_ingredientes;

    @Column(name = "cantidad_aprox_por_kg")
    @NotNull
    private Integer cantidad_aprox_por_kg;

}

