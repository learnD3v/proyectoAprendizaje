package com.hora.delusuario.model;

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
    private ProductEntity id_producto;

    @Column(name = "cantidad_venta")
    private int cantidad_venta;

    @Column(name = "fecha_venta")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fecha_venta;

    // Constructor, getters y setters, etc.
}
