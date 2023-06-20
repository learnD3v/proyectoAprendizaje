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

    public ClienteEntity modificarCliente(ClienteEntity cliente) {
        // Verificar si el cliente existe
        Long clienteId = cliente.getId_cliente();
        Optional<ClienteEntity> clienteExistente = clienteRepository.findById(clienteId);
        if (clienteExistente.isPresent()) {
            // Actualizar los datos del cliente existente
            ClienteEntity clienteModificado = clienteExistente.get();
            clienteModificado.setNombre(cliente.getNombre());
            clienteModificado.setNumero_contacto(cliente.getNumero_contacto());
            clienteModificado.setNumero_ruc(cliente.getNumero_ruc());

            // Guardar el cliente modificado en la base de datos
            return clienteRepository.save(clienteModificado);
        } else {
            // Si el cliente no existe, puedes lanzar una excepción o manejarlo de otra forma apropiada
            throw new ClienteNotFoundException("El cliente con ID " + clienteId + " no existe.");
        }
    }
}
