package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPolyAlphabeticCipher {
    PolyAlphabeticCipher cipher;
    SuperCipher superCipher = new SuperCipher();

    @BeforeEach
    void setup() {
//       cipher=new PolyAlphabeticCipher();
    }

    @Test
    public void TestPolyAlphabeticCipherSimple() {
        String toBeEncrypted = "ABCDEF";
        String keyword = "ayush";
        keyword = keyword.toUpperCase();
        int i = superCipher.addPolyCipher();
        superCipher.getPolyCipher(i).setAll(toBeEncrypted, keyword);
        superCipher.getPolyCipher(i).keywordgenerator();
        assertEquals("AZWVLF", superCipher.getPolyCipher(i).cipher());
    }

    @Test
    public void TestPolyAlphabeticCipherSameLengthKeyword() {
        String toBeEncrypted = "ABCDEF";
        String keyword = "ayusha";
        keyword = keyword.toUpperCase();
        int i = superCipher.addPolyCipher();
        superCipher.getPolyCipher(i).setAll(toBeEncrypted, keyword);
        assertEquals("AZWVLF", superCipher.getPolyCipher(i).cipher());
    }

    @Test
    public void TestPolyAlphabeticCipherDecode() {
        String toBeEncrypted = "AZWVLF";
        String keyword = "ayush";
        keyword = keyword.toUpperCase();
        int i = superCipher.addPolyDecipher();
        superCipher.getPolyDeCipher(i).setAll(toBeEncrypted, keyword);
        superCipher.getPolyDeCipher(i).keywordgenerator();
        assertEquals("ABCDEF", superCipher.getPolyDeCipher(i).cipher());
    }

}
