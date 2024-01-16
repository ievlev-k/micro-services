package ru.itmo.userserver.util;

public class Util {
    public static String getBearerToken(String token) throws IllegalArgumentException{
        if (!token.startsWith("Bearer ")) throw new IllegalArgumentException("invalid length");
        return token.substring(7);
    }
}
