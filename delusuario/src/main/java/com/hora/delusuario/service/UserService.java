package com.hora.delusuario.service;

import com.hora.delusuario.model.UserEntity;
import com.hora.delusuario.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserEntity crearUsuario(UserEntity userEntity) {
        if (userRepository.existsByCorreo(userEntity.getCorreo())) {
            throw new IllegalArgumentException("El correo ya existe");
        }

        if (userEntity.getContrasenha() != null) {
            String contrasenha = userEntity.getContrasenha();

            if (!validarContrasenha(contrasenha)) {
                throw new IllegalArgumentException("La contraseña no cumple con los requisitos de validación");
            }

            String contrasenhaEncriptada = passwordEncoder.encode(contrasenha);
            userEntity.setContrasenha(contrasenhaEncriptada);
        }

        return userRepository.save(userEntity);
    }

    private boolean validarContrasenha(String contrasenha) {
        int longitudMinima = 8;
        boolean noCaracteresRepetidos = true;
        boolean contieneMayuscula = false;
        boolean contieneMinuscula = false;
        boolean contieneNumero = false;
        boolean contieneCaracterEspecial = false;

        if (contrasenha.length() < longitudMinima) {
            return false;
        }

        if (noCaracteresRepetidos && contieneCaracteresRepetidos(contrasenha)) {
            return false;
        }

        // Verificar si la contraseña contiene al menos una letra mayúscula
        for (char c : contrasenha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                contieneMayuscula = true;
                break;
            }
        }

        // Verificar si la contraseña contiene al menos una letra minúscula
        for (char c : contrasenha.toCharArray()) {
            if (Character.isLowerCase(c)) {
                contieneMinuscula = true;
                break;
            }
        }

        // Verificar si la contraseña contiene al menos un número
        for (char c : contrasenha.toCharArray()) {
            if (Character.isDigit(c)) {
                contieneNumero = true;
                break;
            }
        }

        // Verificar si la contraseña contiene al menos un caracter especial
        for (char c : contrasenha.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                contieneCaracterEspecial = true;
                break;
            }
        }

        // Verificar que se cumplan todas las condiciones requeridas
        return contieneMayuscula && contieneMinuscula && contieneNumero && contieneCaracterEspecial;
    }

    private boolean contieneCaracteresRepetidos(String contrasenha) {
        int longitud = contrasenha.length();
        int maxCaracteresRepetidosConsecutivos = 2;

        for (int i = 0; i < longitud - maxCaracteresRepetidosConsecutivos; i++) {
            char currentChar = contrasenha.charAt(i);
            boolean esRepetido = true;

            for (int j = i + 1; j <= i + maxCaracteresRepetidosConsecutivos; j++) {
                if (contrasenha.charAt(j) != currentChar) {
                    esRepetido = false;
                    break;
                }
            }

            if (esRepetido) {
                return true;
            }
        }

        return false;
    }
}