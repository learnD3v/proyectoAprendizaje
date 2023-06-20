package com.hora.delusuario.model;

public class ResetPasswordRequest {
    private String nuevaContrasenha;
    private String confirmarContrasenha;

    // Agrega getters y setters

    public String getNuevaContrasenha() {
        return nuevaContrasenha;
    }

    public void setNuevaContrasenha(String nuevaContrasenha) {
        this.nuevaContrasenha = nuevaContrasenha;
    }

    public String getConfirmarContrasenha() {
        return confirmarContrasenha;
    }

    public void setConfirmarContrasenha(String confirmarContrasenha) {
        this.confirmarContrasenha = confirmarContrasenha;
    }
}
