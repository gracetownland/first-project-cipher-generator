package model;

/*Moves each character by the desired amount and returns the ciphered text. */

public class SubstitutionCipher extends Cipher {
    String toBeEncrypt;
    int moveBy;
    String ciphered;

    public void setAll(String toBeEncrypt, String moveBy) {
        this.toBeEncrypt = toBeEncrypt;
        this.moveBy = Integer.parseInt(moveBy);
        String message = "Substitution Cipher accepted " + toBeEncrypt + " and " + moveBy + " as parameters";
        EventLog.getInstance().logEvent(new Event(message));
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
        String result = encrypted.toString();
        EventLog.getInstance().logEvent(new Event("Poly Alphabetic Cipher has been completed with result " + result));
        return result;
    }



}
