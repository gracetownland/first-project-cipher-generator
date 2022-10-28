package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSubstitutionCipher {
    SubstitutionCipher cipher;
    @BeforeEach
    void setup(){

    }
    @Test
    public void TestSimpleSub(){
        String toBeEncrypted="ABCDEF";
        cipher=new SubstitutionCipher(toBeEncrypted,1);
        String unEncrypted= cipher.getCipher();
        assertEquals("BCDEFG",unEncrypted);
    }
    @Test
    public void TestSimpleSubSpecial(){
        String toBeEncrypted="abcdef";
        cipher=new SubstitutionCipher(toBeEncrypted,1);
        String unEncrypted= cipher.getCipher();
        assertEquals("BCDEFG",unEncrypted);
    }
    @Test
    public void TestSimpleSubMultiple(){
        String toBeEncrypted="ABCDEF";
        String toBeEncrypted2= new SubstitutionCipher(toBeEncrypted,1).getCipher();
        String toBeEncrypted3=new SubstitutionCipher(toBeEncrypted2,1).getCipher();
        String toBeEncrypted4=new SubstitutionCipher(toBeEncrypted3,1).getCipher();
        String unEncrypted= new SubstitutionCipher(toBeEncrypted4,1).getCipher();
        assertEquals("EFGHIJ",unEncrypted);
    }
    @Test
    public void TestSimpleSubDecode(){
        String Encrypted="BCDEFG";
        String unEncrypted= new SubstitutionCipher(Encrypted,-1).getCipher();
        assertEquals("ABCDEF",unEncrypted);
    }

}