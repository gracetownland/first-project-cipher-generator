package model;

public class KeyWordCipher {
    public static String encoder(char[] key) {
        String code = "";

        // This array represents the
        // 26 letters of alphabets
        boolean[] arr = new boolean[26];

        // This loop inserts the keyword
        // at the start of the encoded string
        for (int i = 0; i < key.length; i++) {
            if (key[i] >= 'A' && key[i] <= 'Z') {
                // To check whether the character is inserted
                // earlier in the encoded string or not
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

        // This loop inserts the remaining
        // characters in the encoded string.
        for (int i = 0; i < 26; i++) {
            if (!arr[i]) {
                arr[i] = true;
                code += (char) (i + 65);
            }
        }
        return code;
    }

    // Function that generates encodes(cipher) the message
    static String cipheredIt(String toBeEncrypted, String encoded) {
        String cipher = "";

        // This loop ciphered the message.
        // Spaces, special characters and numbers remain same.
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
