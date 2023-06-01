package com.hora.delusuario.controller;

import com.hora.delusuario.model.HistorialVentaEntity;
import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.service.HistorialVentaService;
import com.hora.delusuario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialVentaController {

    private final HistorialVentaService historialVentaService;
    private final ProductService productService;

    public HistorialVentaController(HistorialVentaService historialVentaService, ProductService productService) {
        this.historialVentaService = historialVentaService;
        this.productService = productService;
    }

    @GetMapping("/venta")
    public List<HistorialVentaDTO> obtenerTodosLosHistorialesVenta() {
        List<HistorialVentaEntity> historialesVenta = historialVentaService.obtenerTodosLosHistorialesVenta();
        List<HistorialVentaDTO> historialesVentaDTO = new ArrayList<>();

        for (HistorialVentaEntity historialVenta : historialesVenta) {
            HistorialVentaDTO historialVentaDTO = new HistorialVentaDTO(
                    historialVenta.getId_venta(),
                    historialVenta.getNombreProducto(),
                    historialVenta.getCantidad_venta(),
                    historialVenta.getFecha_venta()
            );
            historialesVentaDTO.add(historialVentaDTO);
        }

        return historialesVentaDTO;
    }
}
