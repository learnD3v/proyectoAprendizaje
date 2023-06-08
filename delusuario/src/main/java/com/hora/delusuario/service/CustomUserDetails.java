package com.hora.delusuario.service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class    CustomUserDetails implements UserDetails {

    private String correo;
    private String contrasenha;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String correo, String contrasenha, Collection<? extends GrantedAuthority> authorities) {
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasenha;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    // Implementa los demás métodos de UserDetails según tus necesidades

    // Por ejemplo, puedes devolver siempre true en los siguientes métodos para indicar que la cuenta está activa y no ha expirado
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
