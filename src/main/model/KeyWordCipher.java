package model;
/*
this class implements the Key Word Cipher technique
 */

public class KeyWordCipher {
    String encoded;
    String ciphered;
    String toBeEncrypted;
    StringBuilder cipher = new StringBuilder();

    public KeyWordCipher(String keyword, String toBeEncrypted) {
        encoded = encoder(keyword.toCharArray());
        this.toBeEncrypted = toBeEncrypted;
    }

    /*
        MODIFIES: this
        EFFECTS: adds the keyword in front of the alphabets which havent been used in the keyword.
         */
    public String encoder(char[] key) {
        StringBuilder code = new StringBuilder();


        boolean[] arr = new boolean[26];


        for (char c : key) {
            if (c >= 'A' && c <= 'Z') {

                if (!arr[c - 65]) {
                    code.append(c);
                    arr[c - 65] = true;
                }
            } else if (c >= 'a' && c <= 'z') {
                if (!arr[c - 97]) {
                    code.append((char) (c - 32));
                    arr[c - 97] = true;
                }
            }
        }


        for (int i = 0; i < 26; i++) {
            if (!arr[i]) {
                arr[i] = true;
                code.append((char) (i + 65));
            }
        }
        return code.toString();
    }

    /*
    MODIFIES: cipher
    EFFECTS: implements keyword Cipher
     */
    public String cipheredIt() {



        for (int i = 0; i < toBeEncrypted.length(); i++) {
            if (toBeEncrypted.charAt(i) >= 'a' && toBeEncrypted.charAt(i) <= 'z') {
                int pos = toBeEncrypted.charAt(i) - 97;
                cipher.append(encoded.charAt(pos));
            } else if (toBeEncrypted.charAt(i) >= 'A' && toBeEncrypted.charAt(i) <= 'Z') {
                int pos = toBeEncrypted.charAt(i) - 65;
                cipher.append(encoded.charAt(pos));
            } else {
                cipher.append(toBeEncrypted.charAt(i));
            }
        }
        ciphered = cipher.toString();
        return ciphered;
    }

    public String getCiphered() {
        return ciphered;
    }

    public String getKeyword() {
        return encoded;
    }
}
