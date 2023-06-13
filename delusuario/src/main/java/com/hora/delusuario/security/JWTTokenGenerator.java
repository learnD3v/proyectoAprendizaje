package com.hora.delusuario.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class JWTTokenGenerator {
    private SecretKey secretKey;

    public JWTTokenGenerator() {
        // Generar una clave segura para HS512
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(String subject) {
        // Utilizar la clave generada para firmar el token
        byte[] secretKeyBytes = secretKey.getEncoded();
        String base64SecretKey = Base64.getEncoder().encodeToString(secretKeyBytes);

        String token = Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, base64SecretKey)
                .compact();

        return token;
    }
}
