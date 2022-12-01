package model;

public class PolyAlphabeticCipher extends Cipher {
    String toBeEncrypted;
    String keyword;


    public void setAll(String toBeEncrypted, String keyword) {
        this.toBeEncrypted = toBeEncrypted;
        this.keyword = keyword;
        EventLog.getInstance().logEvent(new Event("Poly Alphabetic  Cipher Class has accepted the parameters"));


    }

    /*

       MODIFIES: keyword
       EFFECTS:returns keyword repeated until same length as message
       */
    public String keywordgenerator() {

        StringBuilder keywordBuilder = new StringBuilder(keyword);
        for (int i = 0; ; i++) {

            if (keywordBuilder.length() == toBeEncrypted.length()) {
                break;
            }
            keywordBuilder.append(keywordBuilder.charAt(i));
        }
        keyword = keywordBuilder.toString();
        EventLog.getInstance().logEvent(new Event("Keyword has been generated"));
        return keyword;
    }

    /*
    REQUIRES: toBeEncrypted.length()>keyword.length
    MODIFIES: encrypted
    EFFECTS:returns encrypted text by vignere cypher method
    */

    public String cipher() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < toBeEncrypted.length(); i++) {
            int x = (toBeEncrypted.charAt(i) + keyword.charAt(i)) % 26;
            x += 65;
            encrypted.append((char) x);
        }
        EventLog.getInstance().logEvent(new Event("Poly Alphabetic Cipher has been completed"));
        return encrypted.toString();
    }

    /*
        MODIFIES: original
        EFFECTS:deciphers the encrypted text by reversing the encryption process
        */

}

