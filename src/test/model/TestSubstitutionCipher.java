package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSubstitutionCipher {
    SubstitutionCipher cipher;
    @BeforeEach
    void setup(){
    cipher=new SubstitutionCipher();
    }
    @Test
    public void TestSimpleSub(){
        String toBeEncrypted="ABCDEF";
        int moveBy=1;
        assertEquals("BCDEFG",cipher.substitutionCipher(toBeEncrypted, moveBy));
    }
    @Test
    public void TestSimpleSubSpecial(){
        String toBeEncrypted="abcdef";
        int moveBy=1;

        assertEquals("BCDEFG",cipher.substitutionCipher(toBeEncrypted, moveBy));
    }
    @Test
    public void TestSimpleSubMultiple(){
        String toBeEncrypted="ABCDEF";
        int moveBy=1;
        String toBeEncrypted2= cipher.substitutionCipher(toBeEncrypted, moveBy);
        String toBeEncrypted3=cipher.substitutionCipher(toBeEncrypted2, moveBy);
        String toBeEncrypted4=cipher.substitutionCipher(toBeEncrypted3, moveBy);
        String unEncrypted= cipher.substitutionCipher(toBeEncrypted4, moveBy);
        assertEquals("EFGHIJ",unEncrypted);
    }
    @Test
    public void TestSimpleSubDecode(){
        String toBeEncrypted="BCDEFG";
        int moveBy=1;
        assertEquals("ABCDEF",cipher.substitutionCipher(toBeEncrypted,-1));
    }

}