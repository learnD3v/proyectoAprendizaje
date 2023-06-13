package com.hora.delusuario.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private JwtConfig jwtConfig = JwtConfig.getInstance();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = extractTokenFromRequest(request);

        if (token != null && jwtConfig.validateToken(token)) {
            String username = jwtConfig.getUsernameFromToken(token);
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        // Lógica para extraer el token de la solicitud, por ejemplo, desde el encabezado "Authorization"
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // Ignorar "Bearer " y devolver el token sin ese prefijo
        }

        return null;
    }
}
