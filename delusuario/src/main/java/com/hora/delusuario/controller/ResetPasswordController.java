package com.hora.delusuario.controller;

import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.service.CambioContrasenhaService;
import com.hora.delusuario.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reset")
public class ResetPasswordController {

    @Autowired
    private CambioContrasenhaService cambioContrasenhaService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/token")
    public ResponseEntity<String> resetPassword(@RequestParam("correo") String correo) {
        // Verificar si el correo existe en la base de datos
        if (!userRepository.existsByCorreo(correo)) {
            throw new IllegalArgumentException("Correo no registrado");
        }

        // Generar el token de reinicio
        String tokenReset = cambioContrasenhaService.generateResetToken();

        // Actualizar el token de reinicio en el usuario
        cambioContrasenhaService.generarTokenResetContrasenha(correo);

        // Enviar el token al usuario por correo electrónico
        sendTokenByEmail(correo, tokenReset);

        return ResponseEntity.ok("Token de reinicio generado y enviado al usuario");
    }

    private void sendTokenByEmail(String correoDestinatario, String tokenReset) {
        // Lógica para enviar el token por correo electrónico al usuario
        emailService.enviarCorreoResetContrasenha(correoDestinatario, tokenReset);
    }
        @PostMapping("/change")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String tokenReset, @RequestParam("nuevaContrasenha") String nuevaContrasenha) {
        // Verificar si el token de reinicio es válido y cambiar la contraseña
        cambioContrasenhaService.cambiarContrasenhaConTokenReset(tokenReset, nuevaContrasenha);

        return ResponseEntity.ok("Contraseña cambiada exitosamente");
    }
}

