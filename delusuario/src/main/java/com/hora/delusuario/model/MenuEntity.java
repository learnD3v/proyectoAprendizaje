package com.hora.delusuario.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "menu")
@Getter
@Setter
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "menu_id_plato_seq", allocationSize = 1)
    private Integer id_plato;

    @Column(name = "nombre_plato")
    @NotNull
    private String nombre_plato;

    @ManyToMany
    @JoinTable(
            name = "menu_ingrediente",
            joinColumns = @JoinColumn(name = "id_plato"),
            inverseJoinColumns = @JoinColumn(name = "id_ingrediente")
    )
    private List<ProductEntity> ingredientes;

    @Column(name = "precio")
    @NotNull
    private double precio;


    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public List<ProductEntity> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductEntity> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
