package com.hora.delusuario.repository;

import com.hora.delusuario.model.MenuEntity;
import com.hora.delusuario.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
    // Método para obtener todos los platos del menú
    List<MenuEntity> findAll();
}
