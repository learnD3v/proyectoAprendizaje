package com.hora.delusuario.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "cliente")
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(name = "nombre", length = 100)
    @NotNull
    private String nombre;

    @Column(name = "numero_contacto", length = 25)
    private String numero_contacto;

    @Column(name = "numero_ruc", length = 60)
    @NotNull
    private String numero_ruc;

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(String numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getNumero_ruc() {
        return numero_ruc;
    }

    public void setNumero_ruc(String numero_ruc) {
        this.numero_ruc = numero_ruc;
    }
}

