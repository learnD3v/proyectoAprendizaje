package com.hora.delusuario.controller;

import java.time.LocalDateTime;

public class HistorialVentaDTO {
    private Long id_venta;
    private String nombre_producto;
    private int cantidad_venta;
    private LocalDateTime fecha_venta;

    public HistorialVentaDTO(Long id_venta, String nombre_producto, int cantidad_venta, LocalDateTime fecha_venta) {
        this.id_venta = id_venta;
        this.nombre_producto = nombre_producto;
        this.cantidad_venta = cantidad_venta;
        this.fecha_venta = fecha_venta;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public LocalDateTime getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
}
