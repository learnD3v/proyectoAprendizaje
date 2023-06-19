package com.hora.delusuario.security;

public class AuthenticationRequest {
    private String correo;
    private String contrasenha;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.correo = username;
        this.contrasenha = password;
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

