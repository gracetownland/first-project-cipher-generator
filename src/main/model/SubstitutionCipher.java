package model;

/*Moves each character by the desired amount and returns the ciphered text. */

public class SubstitutionCipher extends Cipher {
    String toBeEncrypt;
    int moveBy;
    String ciphered;

    public void setAll(String toBeEncrypt, String moveBy) {
        this.toBeEncrypt = toBeEncrypt;
        this.moveBy = Integer.parseInt(moveBy);
        //cipher();
    }

    /*  MODIFIES: this
     *   EFFECTS:implements substitution cipher*/
    public String cipher() {
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
        EventLog.getInstance().logEvent(new Event("Substitution Cipher has been completed"));
        return ciphered;
    }



}
