package com.example.ovi.securedcommunication;

/**
 * Created by ovi on 7/7/17.
 */

public class Decryption {
    public static String decrypt(String s, int keyLength) {
        String decrypted = "";
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c - (keyLength % 26);
                if (c < 'A')
                    c = c + 26;
            }
            else if (Character.isLowerCase(c)) {
                c = c - (keyLength % 26);
                if (c < 'a')
                    c = c + 26;
            }
            decrypted = decrypted + (char) c;
        }
        return decrypted;
    }
}
