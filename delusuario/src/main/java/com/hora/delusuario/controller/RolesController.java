package com.hora.delusuario.controller;

import com.hora.delusuario.model.RolesEntity;
import com.hora.delusuario.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public List<RolesEntity> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesEntity> getRoleById(@PathVariable Integer id) {
        RolesEntity role = rolesService.getRoleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RolesEntity> createRole(@RequestBody RolesEntity role) {
        RolesEntity createdRole = rolesService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesEntity> updateRole(@PathVariable Integer id, @RequestBody RolesEntity role) {
        if (!id.equals(role.getId_rol())) {
            return ResponseEntity.badRequest().build();
        }

        RolesEntity updatedRole = rolesService.updateRole(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
