package com.hora.delusuario.service;
/*
import com.hora.delusuario.model.DetalleVentaEntity;
import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.repository.DetalleVentaRepository;
import com.hora.delusuario.repository.HistorialVentaRepository;
import com.hora.delusuario.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;
    private final HistorialVentaRepository historialVentaRepository;
    private final ProductRepository productRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository,
                               HistorialVentaRepository historialVentaRepository,
                               ProductRepository productRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.historialVentaRepository = historialVentaRepository;
        this.productRepository = productRepository;
    }

    public List<Object[]> obtenerResumenVentas() {
        return detalleVentaRepository.obtenerResumenVentas();
    }

    public void venderProductos(List<VentaItem> ventaItems) {
        HistorialVentaEntity historialVenta = new HistorialVentaEntity();
        historialVenta.setFecha_venta(LocalDateTime.now());
        historialVentaRepository.save(historialVenta);

        for (VentaItem ventaItem : ventaItems) {
            Integer idProducto = ventaItem.getId_producto().getId_producto();
            int cantidadVenta = ventaItem.getCantidad_venta();
            ProductEntity producto = getProductById(idProducto);

            int cantidadDisponible = producto.getCantidad();
            if (cantidadVenta <= 0) {
                throw new IllegalArgumentException("La cantidad de venta debe ser mayor que cero");
            }
            if (cantidadDisponible < cantidadVenta) {
                throw new IllegalArgumentException("No hay suficiente cantidad disponible para vender");
            }

            producto.setCantidad(cantidadDisponible - cantidadVenta);
            productRepository.save(producto);

            historialVenta.getDetallesVenta().add(guardarDetalleVenta(historialVenta, producto, cantidadVenta));
        }
        historialVentaRepository.save(historialVenta);
    }

    public DetalleVentaEntity guardarDetalleVenta(HistorialVentaEntity historialVenta, ProductEntity producto, int cantidadVenta) {
        DetalleVentaEntity detalleVenta = new DetalleVentaEntity();
        detalleVenta.setHistorialVenta(historialVenta);
        detalleVenta.setProducto(producto);
        detalleVenta.setCantidad_venta(cantidadVenta);

        return detalleVentaRepository.save(detalleVenta);
    }

    private ProductEntity getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
    }

    // Otros métodos del servicio según tus necesidades
}
*/


