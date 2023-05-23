package com.hora.delusuario.service;

import com.hora.delusuario.model.ProductEntity;
import com.hora.delusuario.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsService(IngredientsRepository ingredientsRepository){
        this.ingredientsRepository = ingredientsRepository;
    }
    public void cargarIngrediente(String nombre_ingrediente, int cantidad, double precio_ingredientes, int cantidad_aprox_por_kg) {
        ProductEntity ingrediente = new ProductEntity();
        ingrediente.setNombre_ingrediente(nombre_ingrediente);
        ingrediente.setCantidad(cantidad);
        ingrediente.setPrecio_ingredientes(precio_ingredientes);
        ingrediente.setCantidad_aprox_por_kg(cantidad_aprox_por_kg);
        ingredientsRepository.save(ingrediente);
    }
    public List<ProductEntity> obtenerTodosLosIngredientes() {
        return ingredientsRepository.findAll();
    }

}
