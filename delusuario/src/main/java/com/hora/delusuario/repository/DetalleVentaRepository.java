package com.hora.delusuario.repository;
/*
import com.hora.delusuario.model.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {

    @Query(value = "SELECT hv.id_venta AS \"Código de ventas\", " +
            "STRING_AGG(p.nombre_producto || ' (' || dv.cantidad_venta || ')', ', ') AS Productos, " +
            "SUM(dv.cantidad_venta * p.precio_producto) AS \"Costo total\", " +
            "hv.fecha_venta AS \"Fecha de venta\" " +
            "FROM historial_venta hv " +
            "JOIN detalle_venta dv ON hv.id_venta = dv.id_venta " +
            "JOIN producto p ON dv.producto = p.id_producto " +
            "GROUP BY hv.id_venta, hv.fecha_venta", nativeQuery = true)
    List<Object[]> obtenerResumenVentas();

}
*/