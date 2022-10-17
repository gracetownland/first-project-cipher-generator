package model;
/*
this class implements the Key Word Cipher technique
 */

public class KeyWordCipher {
    /*
    MODIFIES: this
    EFFECTS: adds the keyword in front of the alphabets which havent been used in the keyword.
     */
    public static String encoder(char[] key) {
        String code = "";


        boolean[] arr = new boolean[26];


        for (int i = 0; i < key.length; i++) {
            if (key[i] >= 'A' && key[i] <= 'Z') {

                if (!arr[key[i] - 65]) {
                    code += (char) key[i];
                    arr[key[i] - 65] = true;
                }
            } else if (key[i] >= 'a' && key[i] <= 'z') {
                if (!arr[key[i] - 97]) {
                    code += (char) (key[i] - 32);
                    arr[key[i] - 97] = true;
                }
            }
        }


        for (int i = 0; i < 26; i++) {
            if (!arr[i]) {
                arr[i] = true;
                code += (char) (i + 65);
            }
        }
        return code;
    }

    /*
    MODIFIES: cipher
    EFFECTS: implements keyword Cipher
     */
    public static String cipheredIt(String toBeEncrypted, String encoded) {
        String cipher = "";


        for (int i = 0; i < toBeEncrypted.length(); i++) {
            if (toBeEncrypted.charAt(i) >= 'a' && toBeEncrypted.charAt(i) <= 'z') {
                int pos = toBeEncrypted.charAt(i) - 97;
                cipher += encoded.charAt(pos);
            } else if (toBeEncrypted.charAt(i) >= 'A' && toBeEncrypted.charAt(i) <= 'Z') {
                int pos = toBeEncrypted.charAt(i) - 65;
                cipher += encoded.charAt(pos);
            } else {
                cipher += toBeEncrypted.charAt(i);
            }
        }
        return cipher;
    }
}
