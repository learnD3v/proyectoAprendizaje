package com.hora.delusuario.repository;

import com.hora.delusuario.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}

