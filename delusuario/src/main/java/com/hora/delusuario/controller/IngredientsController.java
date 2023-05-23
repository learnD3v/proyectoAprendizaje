package com.hora.delusuario.controller;

import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.service.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService){
        this.ingredientsService = ingredientsService;
    }
    @GetMapping("/todos")
    public ResponseEntity<List<ProductEntity>> obtenerTodosLosIngredientes() {
        List<ProductEntity> ingredientes = ingredientsService.obtenerTodosLosIngredientes();
        return ResponseEntity.ok(ingredientes);
    }
    @PostMapping("/cargar")
    public ResponseEntity<?> cargarIngrediente(@RequestBody ProductEntity ingredientes) {
        ingredientsService.cargarIngrediente(ingredientes.getNombre_ingrediente(), ingredientes.getCantidad(), ingredientes.getPrecio_ingredientes(), ingredientes.getCantidad_aprox_por_kg());
        return ResponseEntity.ok("Ingrediente cargado exitosamente");
    }
}