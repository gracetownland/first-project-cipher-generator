package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKeyWordCipher {
    KeyWordCipher cipher;
    SuperCipher superCipher = new SuperCipher();


    @BeforeEach
    void setup(){
       // cipher=new KeyWordCipher();
    }

    @Test
    void testKeyWordCipherSimple(){

        String keyword =  superCipher.getKeyCipher().encoder("thisiscool".toCharArray());
        String toBeEncrypted = "ayushfeelsverycoolbutwantsto";
        superCipher.getKeyCipher().setAll(toBeEncrypted,keyword);
        assertEquals(keyword, superCipher.getKeyCipher().getEncoded());

        assertEquals("TYUQAOCCFQVCPYIKKFHURWTJRQRK",superCipher.getKeyCipher().cipher());
    }

    @Test
    void testKeyWordCipherSimpleCAPS() {
        String keyword = superCipher.getKeyCipher().encoder("THISISCOOL".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO";
        superCipher.getKeyCipher().setAll(toBeEncrypted,keyword);
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK", superCipher.getKeyCipher().cipher());
    }
    @Test
    void testKeyWordCipherSpecialChar() {
        String keyword = superCipher.getKeyCipher().encoder("thisiscool".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO$";
        superCipher.getKeyCipher().setAll(toBeEncrypted,keyword);
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK$", superCipher.getKeyCipher().cipher());
    }

}
