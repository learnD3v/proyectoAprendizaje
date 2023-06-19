package com.hora.delusuario.model;
/*
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detallesVenta = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCargaEntity> detallesCarga = new ArrayList<>();


    // Constructor, getters y setters

    public ProveedorEntity getProveedorEntity() {
        return proveedor;
    }

    public void setProveedorEntity(ProveedorEntity proveedorEntity) {
        this.proveedor = proveedorEntity;
    }
    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
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
        return id_producto;
    }

}
*/
