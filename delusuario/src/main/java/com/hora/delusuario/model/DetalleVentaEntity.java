package com.hora.delusuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "detalle_venta")
@Getter
@Setter
public class DetalleVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    @JsonIgnore
    private HistorialVentaEntity historialVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
    private ProductEntity producto;

    @Column(name = "cantidad_venta")
    private int cantidad_venta;
    // Resto de los métodos, constructores, getters y setters


    // Constructor
    public DetalleVentaEntity() {
    }

    // Getter y Setter de id_detalle_venta
    public Integer getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(Integer id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    // Getter y Setter de historialVenta
    public HistorialVentaEntity getHistorialVenta() {
        return historialVenta;
    }

    public void setHistorialVenta(HistorialVentaEntity historialVenta) {
        this.historialVenta = historialVenta;
    }

    // Getter y Setter de producto
    public ProductEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductEntity producto) {
        this.producto = producto;
    }

    // Getter y Setter de cantidad_venta
    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }
}
