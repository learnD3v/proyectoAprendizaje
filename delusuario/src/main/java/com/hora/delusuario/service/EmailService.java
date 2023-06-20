package com.hora.delusuario.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class EmailService {
    private final String correoEmisor = "thegardensublime@gmail.com";
    private final String password = "otbbsjrghjqytdgs";
    private final String host = "smtp.gmail.com";
    private final int puerto = 587;

    public void enviarCorreoResetContrasenha(String correoDestinatario, String tokenReset) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEmisor, password);
            }
        });

        try {
            // Crear un objeto MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Establecer el remitente, destinatario, asunto y contenido del correo
            message.setFrom(new InternetAddress(correoEmisor));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestinatario));
            message.setSubject("Restablecimiento de contraseña");

            // Construir el enlace de recuperación de contraseña
            String resetLink = "http://localhost:8080/api/reset/change/" + tokenReset;

            // Establecer el contenido del correo con el enlace de recuperación de contraseña
            message.setText("Haga clic en el siguiente enlace para restablecer su contraseña: " + resetLink);

            // Enviar el correo
            Transport.send(message);

            // El correo se envió correctamente
            System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            // Ocurrió un error al enviar el correo
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
