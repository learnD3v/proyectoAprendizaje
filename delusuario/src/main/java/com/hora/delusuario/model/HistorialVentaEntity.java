package com.hora.delusuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hora.delusuario.model.convertidoresfecha.TimestampToLocalTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "historial_venta")
@Getter
@Setter
public class HistorialVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonIgnore
    private ProductEntity producto;

    @Column(name = "cantidad_venta")
    private int cantidad_venta;

    @Column(name = "fecha_venta")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fecha_venta;

    // Constructor, getters y setters, etc.

    @JsonProperty("nombre_producto")
    public String getNombreProducto() {
        return producto != null ? producto.getNombre_producto() : null;
    }
}