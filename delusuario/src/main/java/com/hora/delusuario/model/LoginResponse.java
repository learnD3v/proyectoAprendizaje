package com.hora.delusuario.model;

public class LoginResponse {
    private String token;
    private Long idSesion;

    public LoginResponse() {
        // Constructor vacío
    }

    public LoginResponse(String token, Long idSesion) {
        this.token = token;
        this.idSesion = idSesion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public String getMessage() {
        return "¡Inicio de sesión exitoso! Su token es: " + token;
    }
}
