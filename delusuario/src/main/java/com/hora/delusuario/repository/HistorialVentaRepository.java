package com.hora.delusuario.repository;

import com.hora.delusuario.model.HistorialVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialVentaRepository extends JpaRepository<HistorialVentaEntity, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}

