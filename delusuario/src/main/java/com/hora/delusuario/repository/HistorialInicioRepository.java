package com.hora.delusuario.repository;

import com.hora.delusuario.controller.HistorialInicioDTO;
import com.hora.delusuario.model.HistorialInicioEntity;
import com.hora.delusuario.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistorialInicioRepository extends JpaRepository<HistorialInicioEntity, Long> {
    @Query("SELECT hi.id_sesion, u.correo, hi.fecha_inicio "
            + "FROM HistorialInicioEntity hi "
            + "JOIN hi.id_usuario u "
            + "ORDER BY hi.fecha_inicio DESC")
    List<Object[]> obtenerHistorialInicioOrdenado();

}