package com.hora.delusuario.repository;

import com.hora.delusuario.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findById(int id_producto);
    void deleteById(int id_producto);

    ProductEntity save(ProductEntity product);
}
