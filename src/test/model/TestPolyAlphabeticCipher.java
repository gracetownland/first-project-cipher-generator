package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPolyAlphabeticCipher {
    PolyAlphabeticCipher cipher;
    @BeforeEach
    void setup(){
       cipher=new PolyAlphabeticCipher();
    }
    @Test
    public void TestPolyAlphabeticCipherSimple(){
        String toBeEncrypted="ABCDEF";
        String keyword="ayush";
        keyword=keyword.toUpperCase();
        String key=cipher.keywordgenerator(toBeEncrypted,keyword);
        assertEquals("AZWVLF",cipher.cypher(toBeEncrypted,key));
    }
    @Test
    public void TestPolyAlphabeticCipherDecode(){
        String Encrypted="AZWVLF";
        String keyword="ayush";
        keyword=keyword.toUpperCase();
        String key=cipher.keywordgenerator(Encrypted,keyword);
        assertEquals("ABCDEF",cipher.decypher(Encrypted,key));
    }

}
