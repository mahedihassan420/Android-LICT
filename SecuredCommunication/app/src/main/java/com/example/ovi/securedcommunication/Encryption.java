package com.example.ovi.securedcommunication;

/**
 * Created by Ovi on 1/28/2017.
 */

public class Encryption {
    public static String encrypt(String s, int keyLength) {
        String encrypted = "";
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (keyLength % 26);
                if (c > 'Z')
                    c = c - 26;
            }
            else if (Character.isLowerCase(c)) {
                c = c + (keyLength % 26);
                if (c > 'z')
                    c = c - 26;
            }
            encrypted = encrypted + (char) c;
        }
        return encrypted;
    }
}
