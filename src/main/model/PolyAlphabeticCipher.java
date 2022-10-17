package model;

public class PolyAlphabeticCipher {
    /*

       MODIFIES: keyword
       EFFECTS:returns keyword repeated until same length as message
       */    public static String keywordgenerator(String toBeEncrypted, String keyword) {
        int l = toBeEncrypted.length();
        for (int i = 0; ; i++) {

            if (keyword.length() == toBeEncrypted.length()) {
                break;
            }
            keyword += (keyword.charAt(i));
        }

        return keyword;
    }

    /*
    REQUIRES: toBeEncrypted.length()>keyword.length
    MODIFIES: encrypted
    EFFECTS:returns encrypted text by vignere cypher method
    */

    public static String cypher(String toBeEncrypted, String keyword) {
        String encrypted = "";
        for (int i = 0; i < toBeEncrypted.length(); i++) {
            int x = (toBeEncrypted.charAt(i) + keyword.charAt(i)) % 26;
            x += 65;
            encrypted += (char) x;
        }
        return encrypted;
    }

    /*
        MODIFIES: original
        EFFECTS:deciphers the encrypted text by reversing the encryption process
        */
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

