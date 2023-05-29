package com.hora.delusuario.service;

import com.hora.delusuario.model.ClienteEntity;
import com.hora.delusuario.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntity crearCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteEntity> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteEntity> obtenerClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    public void eliminarClientePorId(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
