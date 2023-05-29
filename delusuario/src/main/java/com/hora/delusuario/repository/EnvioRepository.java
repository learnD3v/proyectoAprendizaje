package com.hora.delusuario.repository;

import com.hora.delusuario.model.EnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<EnvioEntity, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}