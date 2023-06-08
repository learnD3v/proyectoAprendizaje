package com.hora.delusuario.repository;

import com.hora.delusuario.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario

    RolesEntity findByIdRol(Long idRol);
}


