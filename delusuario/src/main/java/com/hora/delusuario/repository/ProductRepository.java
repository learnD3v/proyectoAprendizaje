package com.hora.delusuario.repository;

import com.hora.delusuario.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByIdProducto(Integer idProducto);
    void deleteByIdProducto(Integer idProducto);

    ProductEntity save(ProductEntity product);
}







