package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKeyWordCipher {
    KeyWordCipher cipher;

    @BeforeEach
    void setup(){
        cipher=new KeyWordCipher();
    }

    @Test
    void testKeyWordCipherSimple(){
        String keyword = cipher.encoder("thisiscool".toCharArray());
        String toBeEncrypted = "ayushfeelsverycoolbutwantsto";
        assertEquals("TYUQAOCCFQVCPYIKKFHURWTJRQRK",cipher.cipheredIt(toBeEncrypted,keyword));
    }

    @Test
    void testKeyWordCipherSimpleCAPS() {
        String keyword = cipher.encoder("thisiscool".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO";
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK", cipher.cipheredIt(toBeEncrypted, keyword));
    }
    @Test
    void testKeyWordCipherSpecialChar() {
        String keyword = cipher.encoder("thisiscool".toCharArray());
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO$";
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK$", cipher.cipheredIt(toBeEncrypted,keyword));
    }

}
