package model;

public class PolyAlphabeticCipher {
    /*

       MODIFIES: keyword
       EFFECTS:returns keyword repeated until same length as message
       */    public  String keywordgenerator(String toBeEncrypted, String keyword) {

        StringBuilder keywordBuilder = new StringBuilder(keyword);
        for (int i = 0; ; i++) {

            if (keywordBuilder.length() == toBeEncrypted.length()) {
                break;
            }
            keywordBuilder.append(keywordBuilder.charAt(i));
        }
        keyword = keywordBuilder.toString();

        return keyword;
    }

    /*
    REQUIRES: toBeEncrypted.length()>keyword.length
    MODIFIES: encrypted
    EFFECTS:returns encrypted text by vignere cypher method
    */

    public  String cypher(String toBeEncrypted, String keyword) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < toBeEncrypted.length(); i++) {
            int x = (toBeEncrypted.charAt(i) + keyword.charAt(i)) % 26;
            x += 65;
            encrypted.append((char) x);
        }
        return encrypted.toString();
    }

    /*
        MODIFIES: original
        EFFECTS:deciphers the encrypted text by reversing the encryption process
        */
    public  String decypher(String encrypted, String keyword) {
        StringBuilder original = new StringBuilder();
        for (int i = 0; i < encrypted.length() && i < keyword.length(); i++) {
            int x = (encrypted.charAt(i) - keyword.charAt(i) + 26) % 26;
            x += 65;
            original.append((char) x);
        }
        return original.toString();
    }
}

