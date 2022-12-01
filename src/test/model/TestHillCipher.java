package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHillCipher {
    HillCipher cipher;
    SuperCipher superCipher = new SuperCipher();
    int i;


    @BeforeEach
    void setup(){
        i = superCipher.addHillCipher();
        //cipher =new HillCipher();
    }

    @Test
    void testHillCipher(){
        String toBeEncrypted="UBCCSS";
        String keyword= "COMPISDEFINITELYFUNFUNFUN";
        superCipher.getHillCipher(i).setAll(toBeEncrypted,keyword);
        assertEquals("SFSRV",superCipher.getHillCipher(i).cipher());
    }
}
