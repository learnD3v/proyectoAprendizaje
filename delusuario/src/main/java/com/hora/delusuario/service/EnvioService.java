package com.hora.delusuario.service;

import com.hora.delusuario.model.EnvioEntity;
import com.hora.delusuario.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Transactional
    public EnvioEntity crearEnvio(EnvioEntity envio) {
        // Realiza las validaciones y lógica de negocio necesarias antes de guardar el envío
        // ...

        return envioRepository.save(envio);
    }

    @Transactional
    public EnvioEntity obtenerEnvio(Long idEnvio) {
        return envioRepository.findById(idEnvio).orElse(null);
    }

    @Transactional
    public void actualizarEnvio(EnvioEntity envio) {
        // Realiza las validaciones y lógica de negocio necesarias antes de actualizar el envío
        // ...

        envioRepository.save(envio);
    }

    @Transactional
    public void eliminarEnvio(Long idEnvio) {
        envioRepository.deleteById(idEnvio);
    }
}
