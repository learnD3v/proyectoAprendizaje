package com.hora.delusuario.controller;

import com.hora.delusuario.model.ProveedorEntity;
import com.hora.delusuario.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping("/crear")
    public ProveedorEntity crearProveedor(@RequestBody ProveedorEntity proveedor) {
        return proveedorService.crearProveedor(proveedor);
    }

    @GetMapping("/mostrar")
    public List<ProveedorEntity> obtenerTodosLosProveedores() {
        return proveedorService.obtenerTodosLosProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorEntity> obtenerProveedorPorId(@PathVariable Integer id) {
        ProveedorEntity proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProveedorEntity> actualizarProveedor(@PathVariable Integer id, @RequestBody ProveedorEntity proveedor) {
        ProveedorEntity proveedorExistente = proveedorService.obtenerProveedorPorId(id);
        if (proveedorExistente != null) {
            proveedor.setId_proveedor(id);
            ProveedorEntity proveedorActualizado = proveedorService.actualizarProveedor(proveedor);
            return ResponseEntity.ok(proveedorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        ProveedorEntity proveedorExistente = proveedorService.obtenerProveedorPorId(id);
        if (proveedorExistente != null) {
            proveedorService.eliminarProveedor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

