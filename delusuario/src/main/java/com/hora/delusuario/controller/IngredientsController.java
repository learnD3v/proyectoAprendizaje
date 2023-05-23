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
    @PutMapping("/{id}")
    public ResponseEntity<?> editarIngrediente(@PathVariable int id, @RequestBody ProductEntity ingredientes) {
        ProductEntity ingredienteExistente = ingredientsService.obtenerIngredientePorId(id);
        if (ingredienteExistente == null) {
            // Manejar el caso en que el ingrediente no exista
            return ResponseEntity.notFound().build();
        }

        // Actualizar los valores del ingrediente existente
        ingredienteExistente.setNombre_ingrediente(ingredientes.getNombre_ingrediente());
        ingredienteExistente.setCantidad(ingredientes.getCantidad());
        ingredienteExistente.setPrecio_ingredientes(ingredientes.getPrecio_ingredientes());
        ingredienteExistente.setCantidad_aprox_por_kg(ingredientes.getCantidad_aprox_por_kg());

        // Guardar los cambios en el servicio de ingredientes
        ingredientsService.guardarIngrediente(ingredienteExistente);

        return ResponseEntity.ok("Ingrediente editado exitosamente");
    }
}
