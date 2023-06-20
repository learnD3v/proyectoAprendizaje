package com.hora.delusuario.controller;

import com.hora.delusuario.model.ResetPasswordRequest;
import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import com.hora.delusuario.service.CambioContrasenhaService;
import com.hora.delusuario.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UserEntity user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new IllegalArgumentException("Correo no registrado");
        }

        // Actualizar el token de reinicio en el usuario
        cambioContrasenhaService.generarTokenResetContrasenha(correo);

        // Obtener el token de reinicio actualizado
        String tokenReset = user.getTokenReset();

        // Enviar el token al usuario por correo electrónico
        sendTokenByEmail(correo, tokenReset);

        return ResponseEntity.ok("Token de reinicio generado y enviado al usuario");
    }
    private void sendTokenByEmail(String correoDestinatario, String tokenReset) {
        // Lógica para enviar el token por correo electrónico al usuario
        emailService.enviarCorreoResetContrasenha(correoDestinatario, tokenReset);
    }
    @PostMapping("/change/{token}")
    public ResponseEntity<String> resetPassword(@PathVariable("token") String tokenReset, @RequestBody ResetPasswordRequest resetPasswordRequest) {
        // Obtener la nueva contraseña y su confirmación del objeto ResetPasswordRequest
        String nuevaContrasenha = resetPasswordRequest.getNuevaContrasenha();
        String confirmarContrasenha = resetPasswordRequest.getConfirmarContrasenha();

        // Verificar si el token de reinicio es válido y cambiar la contraseña
        cambioContrasenhaService.cambiarContrasenhaConTokenReset(tokenReset, nuevaContrasenha, confirmarContrasenha);

        return ResponseEntity.ok("Contraseña cambiada exitosamente");
    }
}

