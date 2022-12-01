package model;

public class PolyAlphabeticCipher extends Cipher {
    String toBeEncrypted;
    String keyword;


    public void setAll(String toBeEncrypted, String keyword) {
        this.toBeEncrypted = toBeEncrypted;
        this.keyword = keyword;
        String firstPart = "Poly Alphabetic Cipher Class has accepted";
        String message = firstPart  + toBeEncrypted + " and " + keyword + "as the parameters";
        EventLog.getInstance().logEvent(new Event(message));


    }

    /*

       MODIFIES: keyword
       EFFECTS:returns keyword repeated until same length as message
       */
    public String keywordgenerator() {
        EventLog.getInstance().logEvent(new Event("Keyword has been generated"));
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

    public String cipher() {

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < toBeEncrypted.length(); i++) {
            int x = (toBeEncrypted.charAt(i) + keyword.charAt(i)) % 26;
            x += 65;
            encrypted.append((char) x);
        }
        String result = encrypted.toString();
        EventLog.getInstance().logEvent(new Event("Poly Alphabetic Cipher has been completed with result " + result));
        return result;
    }

    /*
        MODIFIES: original
        EFFECTS:deciphers the encrypted text by reversing the encryption process
        */

}

