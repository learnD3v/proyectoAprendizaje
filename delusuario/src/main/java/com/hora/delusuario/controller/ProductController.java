package com.hora.delusuario.controller;
/*
import com.hora.delusuario.model.DetalleCargaEntity;
import com.hora.delusuario.model.HistorialProductoEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.repository.DetalleCargaRepository;
import com.hora.delusuario.repository.HistorialProductoRepository;
import com.hora.delusuario.repository.ProductRepository;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private UserRepository userRepository;
    private HistorialProductoRepository historialProductoRepository;
    private DetalleCargaRepository detalleCargaRepository;

    public ProductController(ProductService productService, ProductRepository productRepository, UserRepository userRepository,
                             HistorialProductoRepository historialProductoRepository, DetalleCargaRepository detalleCargaRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.historialProductoRepository = historialProductoRepository;
        this.userRepository = userRepository;
        this.detalleCargaRepository=detalleCargaRepository;

    }


    @GetMapping("/todos")
    public List<LinkedHashMap<String, Object>>obtenerTodosLosProductos() {
           List<Object[]> productos = productRepository.findAllProducts();
        List<LinkedHashMap<String, Object>> todosProductos = new ArrayList<>();
        for (Object[] fila : productos) {
            LinkedHashMap<String, Object> todos = new LinkedHashMap<>();
            todos.put("Codigo", fila[0]);
            todos.put("Producto", fila[1]);
            todos.put("Precio", fila[2]);
            todos.put("Proveedor", fila[3]);
            todos.put("Categoria", fila[4]);
            todosProductos.add(todos);
        }
        return todosProductos;
    }


    @GetMapping("/{id}")
    public ProductEntity obtenerProductoPorId(@PathVariable Integer id) {
        return productService.obtenerProductoPorId(id);
    }

    @PostMapping("/crear")
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
            // Crear una nueva instancia de HistorialProductoEntity
            HistorialProductoEntity historialProducto = new HistorialProductoEntity();

            // Establecer el usuario actual en la instancia de HistorialProductoEntity
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserEntity usuarioActual = (UserEntity) authentication.getPrincipal();
            historialProducto.setIdUsuario(usuarioActual);

            // Establecer la fecha de carga en la instancia de HistorialProductoEntity
            historialProducto.setFechaCarga(LocalDateTime.now());

            // Guardar la instancia de HistorialProductoEntity en la base de datos
            historialProductoRepository.save(historialProducto);

            // Llamar al servicio para modificar la cantidad del producto
            ProductEntity productoModificado = productService.modificarCantidadProducto(idProducto, cantidad);

            // Crear el detalle de carga
            DetalleCargaEntity detalleCarga = new DetalleCargaEntity();
            detalleCarga.setHistorialProducto(historialProducto);
            detalleCarga.setCantidad_carga(cantidad);
            detalleCarga.setProducto(productoModificado);

            // Guardar el detalle de carga
            detalleCargaRepository.save(detalleCarga);

            return ResponseEntity.ok("Cantidad modificada correctamente. Nueva cantidad: " + productoModificado.getCantidad());
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
*/


