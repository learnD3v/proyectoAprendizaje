package com.hora.delusuario.util;

import java.util.UUID;

public class UUIDUtil {
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}