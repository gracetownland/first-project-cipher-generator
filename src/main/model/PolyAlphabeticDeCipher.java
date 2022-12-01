package model;

public class PolyAlphabeticDeCipher extends Cipher {
    String toBeEncrypted;
    String keyword;
    //String key;

    public void setAll(String toBeEncrypted, String keyword) {
        this.toBeEncrypted = toBeEncrypted;
        this.keyword = keyword;
        String firstPart = "Poly Alphabetic Decipher Class has accepted";
        String message = firstPart + toBeEncrypted + " and " + keyword + "as the parameters";
        EventLog.getInstance().logEvent(new Event(message));
    }

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

    public String cipher() {
        StringBuilder original = new StringBuilder();
        for (int i = 0; i < toBeEncrypted.length() && i < keyword.length(); i++) {
            int x = (toBeEncrypted.charAt(i) - keyword.charAt(i) + 26) % 26;
            x += 65;
            original.append((char) x);
        }
        String result = original.toString();
        EventLog.getInstance().logEvent(new Event("Poly Alphabetic Cipher has been completed with result " + result));
        return result;
    }
}
