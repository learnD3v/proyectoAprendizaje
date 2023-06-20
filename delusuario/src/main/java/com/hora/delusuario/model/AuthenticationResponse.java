package com.hora.delusuario.model;

public class AuthenticationResponse {
    private String token;
    private Long idSesion;
    private String username;

    public AuthenticationResponse(String token, String username, Long idSesion) {
        this.token = token;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
