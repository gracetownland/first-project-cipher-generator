package model;

import java.util.Scanner;

public class SubstitutionCipher {
    public static String substitutionCipher(String toBeEncrypted, int moveBy) {
        String toBeEncrypt = toBeEncrypted;

        toBeEncrypt = toBeEncrypt.toLowerCase();
        char[] a = new char[toBeEncrypt.length()];
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            if (a[i] != ' ') {
                char c = toBeEncrypt.charAt(i);
                a[i] = c;
            }
        }
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            if ((int) a[i] + moveBy < 122) {
                a[i] = (char) ((int) a[i] + moveBy);
            } else {
                a[i] = (char) ((int) a[i] - 25 + moveBy);

            }
        }
        String encrypted = "";
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            encrypted = encrypted + a[i];
        }
        return encrypted.toUpperCase();
    }
}
