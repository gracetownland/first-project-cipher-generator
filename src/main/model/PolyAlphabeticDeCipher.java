package model;

public class PolyAlphabeticDeCipher extends Cipher {
    String toBeEncrypted;
    String keyword;
    //String key;

    public void setAll(String toBeEncrypted, String keyword) {
        this.toBeEncrypted = toBeEncrypted;
        this.keyword = keyword;
    }

    public String keywordgenerator() {

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
        return original.toString();
    }
}
