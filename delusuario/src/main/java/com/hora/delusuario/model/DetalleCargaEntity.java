package com.hora.delusuario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/*
@Entity
@Table(name = "detalle_carga")
public class DetalleCargaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_carga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carga")
    private HistorialProductoEntity historialProducto;

    @Column(name = "cantidad_carga")
    @NotNull
    private Integer cantidad_carga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductEntity producto;

    public Integer getId_detalle_carga() {
        return id_detalle_carga;
    }

    public void setId_detalle_carga(Integer id_detalle_carga) {
        this.id_detalle_carga = id_detalle_carga;
    }

    public HistorialProductoEntity getHistorialProducto() {
        return historialProducto;
    }

    public void setHistorialProducto(HistorialProductoEntity historialProducto) {
        this.historialProducto = historialProducto;
    }

    public Integer getCantidad_carga() {
        return cantidad_carga;
    }

    public void setCantidad_carga(Integer cantidad_carga) {
        this.cantidad_carga = cantidad_carga;
    }

    public ProductEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductEntity producto) {
        this.producto = producto;
    }
}
*/