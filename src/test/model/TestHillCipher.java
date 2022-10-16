package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHillCipher {
    HillCipher cipher;
    @BeforeEach
    void setup(){
        cipher =new HillCipher();
    }

    @Test
    void testHillCipher(){
        String toBeEncrypted="UBCCSS";
        String keyword= "COMPISDEFINITELYFUNFUNFUN";
        assertEquals("SFSRV",cipher.hillCipher(toBeEncrypted,keyword));
    }
}
