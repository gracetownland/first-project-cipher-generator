package model;

/*Moves each character by the desired amount and returns the ciphered text. */

public class SubstitutionCipher extends MasterCipher {
    String toBeEncrypt;
    int moveBy;
    String ciphered;

    public SubstitutionCipher(String toBeEncrypted, int moveBy) {
        toBeEncrypt = toBeEncrypted;
        this.moveBy = moveBy;
        substitutionCipher();
    }

    /*  MODIFIES: this
     *   EFFECTS:implements substitution cipher*/
    public String substitutionCipher() {


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
            }
        }
        StringBuilder encrypted = new StringBuilder();
        //reforms string
        for (int i = 0; i < toBeEncrypt.length(); i++) {
            encrypted.append(a[i]);
        }
        ciphered = encrypted.toString().toUpperCase();
        return ciphered;
    }

    public String getCipher() {
        return ciphered;
    }
}
