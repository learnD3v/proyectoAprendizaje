package com.hora.delusuario.model;

public class LoginRequest {
    private String correo;
    private String contrasenha;

    public LoginRequest() {
        // Constructor vacío
    }

    public LoginRequest(String correo, String contrasenha) {
        this.correo = correo;
        this.contrasenha = contrasenha;
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
