package com.hora.delusuario.model;

import com.hora.delusuario.model.convertidoresfecha.TimestampToLocalTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/*
@Entity
@Table(name = "historial_productos")
public class HistorialProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carga")
    private Integer id_carga;

    @ManyToOne
    @JoinColumn(name = "id_detalle_carga")
    private DetalleCargaEntity detalleCarga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UserEntity id_usuario;

    @Column(name = "fecha_carga")
    @Convert(converter = TimestampToLocalTime.class)
    private LocalDateTime fecha_carga;


    @OneToMany(mappedBy = "historialProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCargaEntity> detallesCarga = new ArrayList<>();


    public Integer getIdCarga() {
        return id_carga;
    }

    public void setIdCarga(Integer id_carga) {
        this.id_carga = id_carga;
    }

    public UserEntity getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(UserEntity id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getFechaCarga() {
        return fecha_carga;
    }

    public void setFechaCarga(LocalDateTime fecha_carga) {
        this.fecha_carga = fecha_carga;
    }
}
*/