package com.hora.delusuario.service;

import com.hora.delusuario.model.RolesEntity;
import com.hora.delusuario.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<RolesEntity> getAllRoles() {
        return rolesRepository.findAll();
    }

    public RolesEntity getRoleById(Long id) {
        Optional<RolesEntity> optionalRole = rolesRepository.findById(id);
        return optionalRole.orElse(null);
    }

    public RolesEntity createRole(RolesEntity role) {
        return rolesRepository.save(role);
    }

    public RolesEntity updateRole(RolesEntity role) {
        if (role.getIdRol() == null) {
            throw new IllegalArgumentException("ID del rol no puede ser nulo");
        }
        return rolesRepository.save(role);
    }

    public void deleteRole(Integer id) {
        rolesRepository.deleteById(id.longValue());
    }
}

