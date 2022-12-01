package model;

import java.util.ArrayList;

public class SuperCipher {

    private ArrayList<Cipher> ciphers;

    public SuperCipher() {
//        SubstitutionCipher sub = new SubstitutionCipher();
//        PolyAlphabeticCipher poly = new PolyAlphabeticCipher();
//        PolyAlphabeticDeCipher dePoly = new PolyAlphabeticDeCipher();
//        KeyWordCipher key = new KeyWordCipher();
//        HillCipher hill = new HillCipher();
        ciphers = new ArrayList<>();
//        ciphers.add(sub);
//        ciphers.add(poly);
//        ciphers.add(dePoly);
//        ciphers.add(key);
//        ciphers.add(hill);
    }

    public int addSubCipher() {
        ciphers.add(new SubstitutionCipher());
        return ciphers.size() - 1;
    }

    public int addPolyCipher() {
        ciphers.add(new PolyAlphabeticCipher());
        return ciphers.size() - 1;
    }

    public int addPolyDecipher() {
        ciphers.add(new PolyAlphabeticDeCipher());
        return ciphers.size() - 1;
    }


    public SubstitutionCipher getSubCipher(int i) {
        return (SubstitutionCipher) this.ciphers.get(i);
    }

    public PolyAlphabeticCipher getPolyCipher(int i) {
        return (PolyAlphabeticCipher) this.ciphers.get(i);
    }

    public PolyAlphabeticDeCipher getPolyDeCipher(int i) {
        return (PolyAlphabeticDeCipher) this.ciphers.get(i);
    }

    public KeyWordCipher getKeyCipher() {
        return (KeyWordCipher) this.ciphers.get(3);
    }

    public HillCipher getHillCipher() {
        return (HillCipher) this.ciphers.get(4);
    }
    /*
    make method cipher and extend it to every cipher class
    */


    public String cipher() {
        return null;
    }

    ;

    //public String getEncryptedMessage(){
    //   return
    //}


}
