package com.hora.delusuario.controller;

import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.repository.ProductRepository;
import com.hora.delusuario.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


    @GetMapping("/todos")
    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<ProductEntity> productos = productRepository.findAll();

        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (ProductEntity producto : productos) {
            ProductoDTO productoDTO = new ProductoDTO(
                    producto.getIdProducto(),
                    producto.getNombre_producto(),
                    producto.getCantidad(),
                    producto.getPrecio_producto()
            );

            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }

    @GetMapping("/{id}")
    public ProductEntity obtenerProductoPorId(@PathVariable Integer id) {
        return productService.obtenerProductoPorId(id);
    }

    @PostMapping
    public ProductEntity crearProducto(@RequestBody ProductEntity producto) {
        return productService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public ProductEntity actualizarProducto(@PathVariable Integer id, @RequestBody ProductEntity productoActualizado) {
        return productService.actualizarProducto(id, productoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productService.eliminarProducto(id);
    }

    // Otros métodos del controlador según tus necesidades
    @PutMapping("/cantidad")
    public ResponseEntity<String> modificarCantidadProducto(@RequestBody Map<String, Integer> request) {
        Integer idProducto = request.get("idProducto");
        Integer cantidad = request.get("cantidad");

        if (idProducto == null || cantidad == null) {
            return ResponseEntity.badRequest().body("Debe proporcionar el ID del producto y la nueva cantidad");
        }

        try {
            ProductEntity updatedProduct = productService.modificarCantidadProducto(idProducto, cantidad);
            return ResponseEntity.ok("Cantidad modificada correctamente. Nueva cantidad: " + updatedProduct.getCantidad());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/vender")
    public ResponseEntity<?> venderProductos(@RequestBody List<Map<String, Object>> ventaItems) {
        try {
            List<VentaItem> listaVentaItems = new ArrayList<>();

            for (Map<String, Object> ventaItem : ventaItems) {
                Integer idProducto = (Integer) ventaItem.get("id_producto");
                int cantidadVenta = (int) ventaItem.get("cantidad_venta");

                if (idProducto == null || cantidadVenta <= 0) {
                    throw new IllegalArgumentException("El objeto VentaItem debe contener un id_producto válido y una cantidad mayor a cero");
                }

                ProductEntity productoEnBD = productRepository.findByIdProducto(idProducto)
                        .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));

                VentaItem ventaItemObjeto = new VentaItem(productoEnBD, cantidadVenta);
                listaVentaItems.add(ventaItemObjeto);
            }

            productService.venderProductos(listaVentaItems);
            return ResponseEntity.ok("Productos vendidos exitosamente");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



