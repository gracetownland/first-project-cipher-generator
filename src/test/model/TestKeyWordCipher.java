package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKeyWordCipher {
    KeyWordCipher cipher;

    @BeforeEach
    void setup() {

    }

    @Test
    void testKeyWordCipherSimple() {
        String keyword = "thisiscool";
        String toBeEncrypted = "ayushfeelsverycoolbutwantsto";
        assertEquals("TYUQAOCCFQVCPYIKKFHURWTJRQRK", new KeyWordCipher(keyword, toBeEncrypted).cipheredIt());
    }

    @Test
    void testKeyWordCipherSimpleCAPS() {
        String keyword = "THISISCOOL";
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO";
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK", new KeyWordCipher(keyword, toBeEncrypted).cipheredIt());
    }
    @Test
    void testKeyWordCipherSpecialChar() {
        String keyword = "THISISCOOL";
        String toBeEncrypted = "AYUSHFEELVERYCOOLBUTWANTSTO$";
        assertEquals("TYUQAOCCFVCPYIKKFHURWTJRQRK$", new KeyWordCipher(keyword, toBeEncrypted).cipheredIt());
    }

}
