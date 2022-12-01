package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKeyWordCipher {
    KeyWordCipher cipher;
    SuperCipher superCipher = new SuperCipher();
    int i;

    @BeforeEach
    void setup(){
       // cipher=new KeyWordCipher();
         i = superCipher.addKeyCipher();

    }

    @Test
    void testKeyWordCipherSimple(){
        String keyword =  superCipher.getKeyCipher(i).encoder("thisiscool".toCharArray());
        String toBeEncrypted = "ayushfeelsverycoolbutwantsto";
        superCipher.getKeyCipher(i).setAll(toBeEncrypted,keyword);
        assertEquals(keyword, superCipher.getKeyCipher(i).getEncoded());

        assertEquals("TYUQAOCCFQVCPYIKKFHURWTJRQRK",superCipher.getKeyCipher(i).cipher());
    }

    @Test
    void testKeyWordCipherSimpleCAPS() {
        String keyword = superCipher.getKeyCipher(i).encoder("THISISCOOL".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO";
        superCipher.getKeyCipher(i).setAll(toBeEncrypted,keyword);
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK", superCipher.getKeyCipher(i).cipher());
    }
    @Test
    void testKeyWordCipherSpecialChar() {
        String keyword = superCipher.getKeyCipher(i).encoder("thisiscool".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO$";
        superCipher.getKeyCipher(i).setAll(toBeEncrypted,keyword);
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK$", superCipher.getKeyCipher(i).cipher());
    }

}
