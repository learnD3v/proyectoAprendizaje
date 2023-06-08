package com.hora.delusuario.repository;

import com.hora.delusuario.controller.HistorialInicioDTO;
import com.hora.delusuario.model.HistorialInicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistorialInicioRepository extends JpaRepository<HistorialInicioEntity, Long> {
    @Query("SELECT hi.idSesion, u.idUsuario, u.correo, u.nombre, hi.fechaInicio " +
            "FROM HistorialInicioEntity hi " +
            "JOIN hi.usuario u " +
            "ORDER BY hi.fechaInicio DESC")
    List<HistorialInicioDTO> obtenerHistorialInicioOrdenado();
}

