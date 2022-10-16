package model;

import java.util.Scanner;

public class SubstitutionCipher {
    /*Moves each character by the desired amount and returns the ciphered text. */
    public static String substitutionCipher(String toBeEncrypted, int moveBy) {
        String toBeEncrypt = toBeEncrypted;

        toBeEncrypt = toBeEncrypt.toLowerCase();
        char[] a = new char[toBeEncrypt.length()];
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            //moves every character of string into array
            if (a[i] != ' ') {
                a[i] = toBeEncrypt.charAt(i);
            }
        }
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            //shifts position of each character by desired amount
            if ((int) a[i] + moveBy < 122) {
                a[i] = (char) ((int) a[i] + moveBy);
            } else {
                a[i] = (char) ((int) a[i] - 25 + moveBy);

            }
        }
        String encrypted = "";
        //reforms string
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            encrypted = encrypted + a[i];
        }
        return encrypted.toUpperCase();
    }
}
