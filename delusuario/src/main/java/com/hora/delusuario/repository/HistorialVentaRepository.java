package com.hora.delusuario.repository;

import com.hora.delusuario.model.HistorialVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialVentaRepository extends JpaRepository<HistorialVentaEntity, Integer> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
}

