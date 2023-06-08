package com.hora.delusuario.security;

import com.hora.delusuario.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String correo = authentication.getName();
        String contrasenha = authentication.getCredentials().toString();

        // Obtener los detalles del usuario mediante el UserDetailsService
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(correo);

        // Verificar si las contraseñas coinciden utilizando el PasswordEncoder
        if (passwordEncoder.matches(contrasenha, userDetails.getPassword())) {
            // Si las contraseñas coinciden, se autentica al usuario
            return new UsernamePasswordAuthenticationToken(userDetails, contrasenha, userDetails.getAuthorities());
        } else {
            // Si las contraseñas no coinciden, se lanza una excepción de credenciales inválidas
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

