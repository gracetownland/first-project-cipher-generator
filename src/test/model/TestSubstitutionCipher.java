package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSubstitutionCipher {
    SubstitutionCipher cipher;
    SuperCipher superCipher = new SuperCipher();
    int i;

    @BeforeEach
    void setup() {
        //cipher=new SubstitutionCipher();
        i = superCipher.addSubCipher();
    }

    @Test
    public void TestSimpleSub() {
        String toBeEncrypted = "ABCDEF";
        String moveBy = "1";
        int i = superCipher.addSubCipher();
        superCipher.getSubCipher(i).setAll(toBeEncrypted, moveBy);
        assertEquals("bcdefg", superCipher.getSubCipher(i).cipher());
    }

    @Test
    public void TestSimpleSubSpecial() {
        String toBeEncrypted = "abcdef";
        String moveBy = "1";
        int i = superCipher.addSubCipher();
        superCipher.getSubCipher(i).setAll(toBeEncrypted, moveBy);
        assertEquals("bcdefg", superCipher.getSubCipher(i).cipher());
    }

    @Test
    public void TestSimpleSubMultiple() {
        String toBeEncrypted = "ABCDEF";
        String moveBy = Integer.toString(1);
        int i = superCipher.addSubCipher();
        superCipher.getSubCipher(i).setAll(toBeEncrypted, moveBy);
        String toBeEncrypted2 = superCipher.getSubCipher(i).cipher();
        int i1 = superCipher.addSubCipher();

        superCipher.getSubCipher(i1).setAll(toBeEncrypted2, moveBy);

        String toBeEncrypted3 = superCipher.getSubCipher(i1).cipher();
        int i2 = superCipher.addSubCipher();
        superCipher.getSubCipher(i2).setAll(toBeEncrypted3, moveBy);
        String toBeEncrypted4 = superCipher.getSubCipher(i2).cipher();
        int i3 = superCipher.addSubCipher();
        superCipher.getSubCipher(i3).setAll(toBeEncrypted4, moveBy);
        String unEncrypted = superCipher.getSubCipher(i3).cipher();
        assertEquals("efghij", unEncrypted);
    }

    @Test
    public void TestSimpleSubDecode() {
        String toBeEncrypted = "BCDEFG";
        String moveBy = Integer.toString(-1);
        int i = superCipher.addSubCipher();
        superCipher.getSubCipher(i).setAll(toBeEncrypted, moveBy);
        assertEquals("abcdef",superCipher.getSubCipher(i).cipher());
    }

}