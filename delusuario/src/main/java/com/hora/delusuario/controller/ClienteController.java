package com.hora.delusuario.controller;

import com.hora.delusuario.model.ClienteEntity;
import com.hora.delusuario.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hora.delusuario.repository.HistorialInicioRepository;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final HistorialInicioRepository historialInicioRepository;

    @Autowired
    public ClienteController(ClienteService clienteService, HistorialInicioRepository historialInicioRepository) {
        this.clienteService = clienteService;
        this.historialInicioRepository = historialInicioRepository;
    }

    @PostMapping("/crear")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteEntity>> obtenerTodosLosClientes() {
        List<ClienteEntity> clientes = clienteService.obtenerTodosLosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obtenerClientePorId(@PathVariable("id") Long idCliente) {
        Optional<ClienteEntity> cliente = clienteService.obtenerClientePorId(idCliente);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClientePorId(@PathVariable("id") Long idCliente) {
        clienteService.eliminarClientePorId(idCliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }