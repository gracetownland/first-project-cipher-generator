package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSubstitutionCipher {
    SubstitutionCipher cipher;
    SuperCipher superCipher = new SuperCipher();

    @BeforeEach
    void setup() {
        //cipher=new SubstitutionCipher();
    }

    @Test
    public void TestSimpleSub() {
        String toBeEncrypted = "ABCDEF";
        String moveBy = "1";
        superCipher.getSubCipher().setAll(toBeEncrypted, moveBy);
        assertEquals("BCDEFG", superCipher.getSubCipher().cipher());
    }

    @Test
    public void TestSimpleSubSpecial() {
        String toBeEncrypted = "abcdef";
        String moveBy = "1";
        superCipher.getSubCipher().setAll(toBeEncrypted, moveBy);
        assertEquals("BCDEFG", superCipher.getSubCipher().cipher());
    }

    @Test
    public void TestSimpleSubMultiple() {
        String toBeEncrypted = "ABCDEF";
        String moveBy = Integer.toString(1);
        superCipher.getSubCipher().setAll(toBeEncrypted, moveBy);
        String toBeEncrypted2 = superCipher.getSubCipher().cipher();
        superCipher.getSubCipher().setAll(toBeEncrypted2, moveBy);

        String toBeEncrypted3 = superCipher.getSubCipher().cipher();
        superCipher.getSubCipher().setAll(toBeEncrypted3, moveBy);
        String toBeEncrypted4 = superCipher.getSubCipher().cipher();
        superCipher.getSubCipher().setAll(toBeEncrypted4, moveBy);
        String unEncrypted = superCipher.getSubCipher().cipher();
        assertEquals("EFGHIJ", unEncrypted);
    }

    @Test
    public void TestSimpleSubDecode() {
        String toBeEncrypted = "BCDEFG";
        String moveBy = Integer.toString(-1);
        superCipher.getSubCipher().setAll(toBeEncrypted, moveBy);
        assertEquals("ABCDEF",superCipher.getSubCipher().cipher());
    }

}