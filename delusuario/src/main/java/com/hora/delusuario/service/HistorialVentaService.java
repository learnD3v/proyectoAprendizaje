package com.hora.delusuario.service;
/*
import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.repository.HistorialVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HistorialVentaService {

    private final HistorialVentaRepository historialVentaRepository;

    public HistorialVentaService(HistorialVentaRepository historialVentaRepository) {
        this.historialVentaRepository = historialVentaRepository;
    }

    public HistorialVentaEntity obtenerHistorialVentaPorId(Integer id_venta) {
        return historialVentaRepository.findById(id_venta)
                .orElseThrow(() -> new NoSuchElementException("Historial de venta no encontrado con el ID: " + id_venta));
    }


    public HistorialVentaEntity crearHistorialVenta(HistorialVentaEntity historialVenta) {
        return historialVentaRepository.save(historialVenta);
    }

    public HistorialVentaEntity actualizarHistorialVenta(Integer id, HistorialVentaEntity historialVentaActualizado) {
        HistorialVentaEntity historialVenta = obtenerHistorialVentaPorId(id);
        historialVenta.setDetallesVenta(historialVentaActualizado.getDetallesVenta());
        historialVenta.setFecha_venta(historialVentaActualizado.getFecha_venta());
        return historialVentaRepository.save(historialVenta);
    }

    public void eliminarHistorialVenta(Integer id) {
        HistorialVentaEntity historialVenta = obtenerHistorialVentaPorId(id);
        historialVentaRepository.delete(historialVenta);
    }

    // Otros métodos del servicio según tus necesidades
}
*/