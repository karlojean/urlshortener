package com.urlshortener.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    private static final String BASE62_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generator(String url) throws NoSuchAlgorithmException {
        try {
            String saltedUrl = url + System.currentTimeMillis();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(saltedUrl.getBytes());


            StringBuilder base62String = new StringBuilder();
            for (int i = 0; i < hashBytes.length && base62String.length() < 7; ++i) {
                int index = hashBytes[i] & 0xFF;
                base62String.append(BASE62_CHARS.charAt(index % BASE62_CHARS.length()));
            }

            while (base62String.length() < 7) {
                base62String.append(BASE62_CHARS.charAt(0));
            }

            return base62String.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
