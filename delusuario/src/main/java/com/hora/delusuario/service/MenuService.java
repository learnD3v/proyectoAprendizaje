package com.hora.delusuario.service;

import com.hora.delusuario.model.MenuEntity;
import com.hora.delusuario.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuEntity> obtenerTodosLosPlatos() {
        return menuRepository.findAll();
    }

    public MenuEntity obtenerPlatoPorId(Integer id_plato) {
        return menuRepository.findById(id_plato).orElse(null);
    }

    public void guardarPlato(MenuEntity plato) {
        menuRepository.save(plato);
    }

    public void eliminarPlatoPorId(Integer id_plato) {
        menuRepository.deleteById(id_plato);
    }
}