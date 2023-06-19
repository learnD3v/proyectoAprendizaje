package com.hora.delusuario.service;

import com.hora.delusuario.model.ProveedorEntity;
import com.hora.delusuario.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public ProveedorEntity crearProveedor(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<ProveedorEntity> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    public ProveedorEntity obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public ProveedorEntity actualizarProveedor(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}

