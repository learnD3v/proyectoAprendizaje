package com.hora.delusuario.controller;

import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/todos")
    public ResponseEntity<List<ProductEntity>> obtenerTodosLosProductos() {
        List<ProductEntity> productos = productService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/cargar")
    public ResponseEntity<?> cargarProducto(@RequestBody ProductEntity producto) {
        productService.cargarProducto(producto.getNombre_producto(), producto.getCantidad(), producto.getPrecio_producto());
        return ResponseEntity.ok("Producto cargado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable int id, @RequestBody ProductEntity producto) {
        ProductEntity productoExistente = productService.obtenerProductoPorId(id);
        if (productoExistente == null) {
            // Manejar el caso en que el producto no exista
            return ResponseEntity.notFound().build();
        }

        // Actualizar los valores del producto existente
        productoExistente.setNombre_producto(producto.getNombre_producto());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setPrecio_producto(producto.getPrecio_producto());

        // Guardar los cambios en el servicio de productos
        productService.guardarProducto(productoExistente);

        return ResponseEntity.ok("Producto editado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        productService.eliminarProductoPorId(id);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }
    @PostMapping("/vender")
    public ResponseEntity<?> venderProductos(@RequestBody List<VentaItem> ventaItems) {
        try {
            productService.venderProductos(ventaItems);
            return ResponseEntity.ok("Productos vendidos exitosamente");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

