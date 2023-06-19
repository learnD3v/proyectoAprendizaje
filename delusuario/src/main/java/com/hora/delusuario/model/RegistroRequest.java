package com.hora.delusuario.model;

public class RegistroRequest {
    private String nombre_completo;
    private String correo;
    private String contrasenha;

    public String getNombre() {
        return nombre_completo;
    }

    public void setNombre(String nombre) {
        this.nombre_completo = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}

