package com.hora.delusuario.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hora.delusuario.model.ProductEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;
@CrossOrigin("http://localhost:4200/")
public class ProductoDTO {
    @JsonProperty("idProducto")
    private Integer idProducto;

    @JsonProperty("nombre_producto")
    private String nombre_producto;

    @JsonProperty("cantidad")
    private Integer cantidad;

    @JsonProperty("precio_producto")
    private Double precio_producto;

    public ProductoDTO(Integer idProducto, String nombre_producto, Integer cantidad, Double precio_producto) {
        this.idProducto = idProducto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.precio_producto = precio_producto;
    }

    // Getters y setters
}


