package com.hora.delusuario.repository;

import com.hora.delusuario.model.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
}
