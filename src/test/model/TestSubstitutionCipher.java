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
        String unEncrypted= cipher.substitutionCipher(toBeEncrypted,1);
        assertEquals("BCDEFG",unEncrypted);
    }
    @Test
    public void TestSimpleSubMultiple(){
        String toBeEncrypted="ABCDEF";
        String toBeEncrypted2= cipher.substitutionCipher(toBeEncrypted,1);
        String toBeEncrypted3=cipher.substitutionCipher(toBeEncrypted2,1);
        String toBeEncrypted4=cipher.substitutionCipher(toBeEncrypted3,1);
        String unEncrypted= cipher.substitutionCipher(toBeEncrypted4,1);
        assertEquals("EFGHIJ",unEncrypted);
    }
    @Test
    public void TestSimpleSubDecode(){
        String Encrypted="BCDEFG";
        String unEncrypted= cipher.substitutionCipher(Encrypted,-1);
        assertEquals("ABCDEF",unEncrypted);
    }

}