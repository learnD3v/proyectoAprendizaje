package com.hora.delusuario.repository;

import com.hora.delusuario.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<ProductEntity, Integer> {
}
