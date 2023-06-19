package com.hora.delusuario.controller;
/*
import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.model.convertidoresfecha.VentaItem;
import com.hora.delusuario.service.DetalleVentaService;
import com.hora.delusuario.service.HistorialVentaService;
import com.hora.delusuario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
/*
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/historiales-venta")
public class HistorialVentaController {

    private final HistorialVentaService historialVentaService;
    private final DetalleVentaService detalleVentaService;

    public HistorialVentaController(HistorialVentaService historialVentaService, DetalleVentaService detalleVentaService) {
        this.historialVentaService = historialVentaService;
        this.detalleVentaService = detalleVentaService;
    }
    @GetMapping()
    public ResponseEntity<HistorialVentaEntity> obtenerHistorialVentaPorId(@PathVariable Integer id) {
        try {
            HistorialVentaEntity historialVenta = historialVentaService.obtenerHistorialVentaPorId(id);
            return ResponseEntity.ok(historialVenta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HistorialVentaEntity> crearHistorialVenta(@RequestBody HistorialVentaEntity historialVenta) {
        try {
            HistorialVentaEntity nuevoHistorialVenta = historialVentaService.crearHistorialVenta(historialVenta);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorialVenta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping()
    public ResponseEntity<HistorialVentaEntity> actualizarHistorialVenta(
            @PathVariable Integer id,
            @RequestBody HistorialVentaEntity historialVentaActualizado
    ) {
        try {
            HistorialVentaEntity historialVenta = historialVentaService.actualizarHistorialVenta(id, historialVentaActualizado);
            return ResponseEntity.ok(historialVenta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<Void> eliminarHistorialVenta(@PathVariable Integer id) {
        try {
            historialVentaService.eliminarHistorialVenta(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener el resumen de ventas
    @GetMapping("/resumen-ventas")
    public List<LinkedHashMap<String, Object>> obtenerResumenVentas() {
        List<Object[]> resultados = detalleVentaService.obtenerResumenVentas();

        List<LinkedHashMap<String, Object>> resumenVentas = new ArrayList<>();
        for (Object[] fila : resultados) {
            LinkedHashMap<String, Object> resumenVenta = new LinkedHashMap<>();
            resumenVenta.put("Codigo", fila[0]);
            resumenVenta.put("Productos", fila[1]);
            resumenVenta.put("Costo", fila[2]);
            resumenVenta.put("Fecha", fila[3]);
            resumenVentas.add(resumenVenta);
        }

        return resumenVentas;
    }

    // Endpoint para vender productos
    @PostMapping("/vender-productos")
    public void venderProductos(@RequestBody List<VentaItem> ventaItems) {
        detalleVentaService.venderProductos(ventaItems);
    }

    // Otros métodos del controlador según tus necesidades
}
*/