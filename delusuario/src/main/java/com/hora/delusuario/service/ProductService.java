package com.hora.delusuario.service;

import com.hora.delusuario.model.DetalleVentaEntity;
import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.repository.DetalleVentaRepository;
import com.hora.delusuario.repository.HistorialVentaRepository;
import com.hora.delusuario.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final HistorialVentaRepository historialVentaRepository;

    public ProductService(ProductRepository productRepository, HistorialVentaRepository historialVentaRepository) {
        this.productRepository = productRepository;
        this.historialVentaRepository = historialVentaRepository;
    }

    public List<ProductEntity> obtenerTodosLosProductos() {
        return productRepository.findAll();
    }

    public ProductEntity obtenerProductoPorId(Integer id) {
        return productRepository.findByIdProducto(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
    }

    public ProductEntity crearProducto(ProductEntity producto) {
        return productRepository.save(producto);
    }

    public ProductEntity actualizarProducto(Integer id, ProductEntity productoActualizado) {
        ProductEntity producto = obtenerProductoPorId(id);
        producto.setNombre_producto(productoActualizado.getNombre_producto());
        producto.setCantidad(productoActualizado.getCantidad());
        producto.setPrecio_producto(productoActualizado.getPrecio_producto());
        return productRepository.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productRepository.deleteByIdProducto(id);
    }

    // Otros métodos del servicio según tus necesidades

    public ProductEntity modificarCantidadProducto(Integer idProducto, Integer cantidad) {
        Optional<ProductEntity> optionalProduct = productRepository.findByIdProducto(idProducto);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        ProductEntity product = optionalProduct.get();
        Integer nuevaCantidad = product.getCantidad() + cantidad;
        product.setCantidad(nuevaCantidad);

        return productRepository.save(product);
    }

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public void venderProductos(List<VentaItem> ventaItems) {
        HistorialVentaEntity historialVenta = new HistorialVentaEntity();
        historialVenta.setFecha_venta(LocalDateTime.now());
        historialVentaRepository.save(historialVenta);

        for (VentaItem ventaItem : ventaItems) {
            Integer idProducto = ventaItem.getId_producto().getId_producto();
            int cantidadVenta = ventaItem.getCantidad_venta();
            ProductEntity producto = productRepository.findByIdProducto(idProducto)
                    .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
            int cantidadDisponible = producto.getCantidad();

            if (cantidadVenta <= 0) {
                throw new IllegalArgumentException("La cantidad de venta debe ser mayor que cero");
            }
            if (cantidadDisponible < cantidadVenta) {
                throw new IllegalArgumentException("No hay suficiente cantidad disponible para vender");
            }

            producto.setCantidad(cantidadDisponible - cantidadVenta);
            productRepository.save(producto);

            DetalleVentaEntity detalleVenta = new DetalleVentaEntity();
            detalleVenta.setHistorialVenta(historialVenta);
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad_venta(cantidadVenta);
            detalleVentaRepository.save(detalleVenta);

            historialVenta.getDetallesVenta().add(detalleVenta);
        }
        historialVentaRepository.save(historialVenta);
    }
}














