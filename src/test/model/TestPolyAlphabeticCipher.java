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
        superCipher.getPolyCipher().setAll(toBeEncrypted, keyword);
        superCipher.getPolyCipher().keywordgenerator();
        assertEquals("AZWVLF", superCipher.getPolyCipher().cipher());
    }

    @Test
    public void TestPolyAlphabeticCipherSameLengthKeyword() {
        String toBeEncrypted = "ABCDEF";
        String keyword = "ayusha";
        keyword = keyword.toUpperCase();
        superCipher.getPolyCipher().setAll(toBeEncrypted, keyword);
        assertEquals("AZWVLF", superCipher.getPolyCipher().cipher());
    }

    @Test
    public void TestPolyAlphabeticCipherDecode() {
        String toBeEncrypted = "AZWVLF";
        String keyword = "ayush";
        keyword = keyword.toUpperCase();
        superCipher.getPolyDeCipher().setAll(toBeEncrypted, keyword);
        superCipher.getPolyDeCipher().keywordgenerator();
        assertEquals("ABCDEF", superCipher.getPolyDeCipher().cipher());
    }

}
