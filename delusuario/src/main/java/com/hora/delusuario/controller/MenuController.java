package com.hora.delusuario.controller;

import com.hora.delusuario.model.MenuEntity;
import com.hora.delusuario.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<MenuEntity>> obtenerTodosLosPlatos() {
        List<MenuEntity> platos = menuService.obtenerTodosLosPlatos();
        return ResponseEntity.ok(platos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuEntity> obtenerPlatoPorId(@PathVariable Integer id) {
        MenuEntity plato = menuService.obtenerPlatoPorId(id);
        if (plato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(plato);
    }

    @PostMapping("/guardar")
    public ResponseEntity<MenuEntity> guardarPlato(@RequestBody MenuEntity plato) {
        menuService.guardarPlato(plato);
        return ResponseEntity.ok(plato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPlatoPorId(@PathVariable Integer id) {
        menuService.eliminarPlatoPorId(id);
        return ResponseEntity.ok("Plato eliminado exitosamente");
    }
}