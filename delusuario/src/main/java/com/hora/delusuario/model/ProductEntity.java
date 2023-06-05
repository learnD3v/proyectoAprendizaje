package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "producto")
@Getter
@Setter
@JsonIgnoreProperties("detallesVenta")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_id_producto_seq", allocationSize = 1)
    private Integer idProducto; // Cambiado de id_producto a idProducto

    @Column(name = "nombre_producto")
    @NotNull
    private String nombre_producto;

    @Column(name = "cantidad")
    @NotNull
    private Integer cantidad;

    @Column(name = "precio_producto")
    @NotNull
    private Double precio_producto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detallesVenta = new ArrayList<>();


    public Integer getId_producto() {
        return idProducto;
    }

    public void setId_producto(Integer id_producto) {
        this.idProducto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public List<DetalleVentaEntity> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVentaEntity> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public Integer getId() {
        return idProducto;
    }
}


