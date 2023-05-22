package com.hora.delusuario.model;

public class LoginResponse {
    private String token;

    public LoginResponse() {
        // Constructor vacío
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return "¡Inicio de sesión exitoso! Su token es: " + token;
    }
}
