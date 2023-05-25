package com.hora.delusuario.service;

import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
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

    @Autowired
    public ProductService(ProductRepository productRepository, HistorialVentaRepository historialVentaRepository) {
        this.productRepository = productRepository;
        this.historialVentaRepository = historialVentaRepository;
    }

    public void cargarProducto(String nombre_producto, int cantidad, double precio_producto) {
        ProductEntity producto = new ProductEntity();
        producto.setNombre_producto(nombre_producto);
        producto.setCantidad(cantidad);
        producto.setPrecio_producto(precio_producto);
        productRepository.save(producto);
    }

    public List<ProductEntity> obtenerTodosLosProductos() {
        return productRepository.findAll();
    }

    public ProductEntity obtenerProductoPorId(int id_producto) {
        return productRepository.findById(id_producto);
    }



    public void guardarProducto(ProductEntity producto) {
        productRepository.save(producto);
    }

    public void eliminarProductoPorId(int id_producto) {
        productRepository.deleteById(id_producto);
    }
    public void venderProductos(List<VentaItem> ventaItems) {
        for (VentaItem ventaItem : ventaItems) {
            Integer idProducto = ventaItem.getId_producto().getId_producto(); // Obtener el ID del producto
            int cantidadVenta = ventaItem.getCantidad_venta();

            ProductEntity producto = productRepository.findById(idProducto).orElse(null);

            if (producto == null) {
                throw new NoSuchElementException("Producto no encontrado");
            }

            int cantidadDisponible = producto.getCantidad();
            if (cantidadVenta <= 0) {
                throw new IllegalArgumentException("La cantidad de venta debe ser mayor que cero");
            }

            if (cantidadDisponible < cantidadVenta) {
                throw new IllegalArgumentException("No hay suficiente cantidad disponible para vender");
            }

            producto.setCantidad(cantidadDisponible - cantidadVenta);
            productRepository.save(producto);

            HistorialVentaEntity historialVenta = new HistorialVentaEntity();
            historialVenta.setId_producto(producto);
            historialVenta.setCantidad_venta(cantidadVenta);
            historialVenta.setFecha_venta(LocalDateTime.now());
            historialVentaRepository.save(historialVenta);
        }
    }
}
