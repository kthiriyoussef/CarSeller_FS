package com.youssef.users.token;
import java.security.SecureRandom;

public class TokenGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int TOKEN_LENGTH = 6;

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(randomIndex));
        }

        return token.toString();
    }
}