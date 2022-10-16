package model;

public class PolyAlphabeticCipher {
    //keyword is repeated until it is the same length of the word to be encrypted
    public static String keywordgenerator(String toBeEncrypted, String keyword) {
        int l = toBeEncrypted.length();
        for (int i = 0; ; i++) {
            if (l == i) {
                i = 0;
            }
            if (keyword.length() == toBeEncrypted.length()) {
                break;
            }
            keyword += (keyword.charAt(i));
        }

        return keyword;
    }

    //returns encrypted text by vignere cypher method
    public static String cypher(String toBeEncrypted, String keyword) {
        String encrypted = "";
        for (int i = 0; i < toBeEncrypted.length(); i++) {
            int x = (toBeEncrypted.charAt(i) + keyword.charAt(i)) % 26;
            x += 65;
            encrypted += (char) x;
        }
        return encrypted;
    }

    //decrpyhers the encrypted text by reversing the encryption process
    public static String decypher(String encrypted, String keyword) {
        String original = "";
        for (int i = 0; i < encrypted.length() && i < keyword.length(); i++) {
            int x = (encrypted.charAt(i) - keyword.charAt(i) + 26) % 26;
            x += 65;
            original += (char) x;
        }
        return original;
    }
}

