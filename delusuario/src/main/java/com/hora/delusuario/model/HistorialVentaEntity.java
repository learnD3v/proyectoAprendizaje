package com.hora.delusuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hora.delusuario.model.convertidoresfecha.TimestampToLocalTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "historial_venta")
@Getter
@Setter
public class HistorialVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    @OneToMany(mappedBy = "historialVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detallesVenta = new ArrayList<>();

    @Column(name = "fecha_venta")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fecha_venta;


    // Constructor, getters y setters, etc.
    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    // Getter y Setter de detallesVenta
    public List<DetalleVentaEntity> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVentaEntity> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    // Getter y Setter de fecha_venta
    public LocalDateTime getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
}