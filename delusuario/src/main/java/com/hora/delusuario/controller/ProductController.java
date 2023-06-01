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
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PathVariable;

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
        if (productoExistente != null) {
            Integer cantidadExistente = productoExistente.getCantidad();
            int cantidadExistenteInt = cantidadExistente != null ? cantidadExistente.intValue() : 0;
            int cantidadAdicional = producto.getCantidad();
            int nuevaCantidad = cantidadExistenteInt + cantidadAdicional;
            productoExistente.setCantidad(nuevaCantidad);
            productoExistente.setNombre_producto(producto.getNombre_producto());
            productoExistente.setPrecio_producto(producto.getPrecio_producto());
            productService.guardarProducto(productoExistente);
            return ResponseEntity.ok("Producto editado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id_producto) {
        productService.eliminarProductoPorId(id_producto);
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
    @PutMapping("/cantidad")
    public ResponseEntity<String> modificarCantidadProducto(@RequestBody Map<String, Integer> requestBody) {
        Integer id_producto = requestBody.get("id_producto");
        Integer cantidad = requestBody.get("cantidad");
        if (id_producto != null && cantidad != null) {
            try {
                ProductEntity updatedProduct = productService.modificarCantidadProducto(id_producto, cantidad);
                return ResponseEntity.ok("Cantidad modificada correctamente. Nueva cantidad: " + updatedProduct.getCantidad());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("El cuerpo de la solicitud debe contener los parámetros 'id_producto' y 'cantidad'.");
        }
    }
    @GetMapping("/producto/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable int id) {
        ProductEntity product = productService.obtenerProductoPorId(id);
        if (product != null) {
            ProductoDTO productoDTO = new ProductoDTO(product.getId_producto(), product.getNombre_producto());
            return ResponseEntity.ok(productoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


