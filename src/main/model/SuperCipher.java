package model;

import java.util.ArrayList;

public class SuperCipher {

    private ArrayList<Cipher> coll;

    public SuperCipher() {
        SubstitutionCipher sub = new SubstitutionCipher();
        PolyAlphabeticCipher poly = new PolyAlphabeticCipher();
        PolyAlphabeticDeCipher dePoly = new PolyAlphabeticDeCipher();
        KeyWordCipher key = new KeyWordCipher();
        HillCipher hill = new HillCipher();
        coll = new ArrayList<>();
        coll.add(sub);
        coll.add(poly);
        coll.add(dePoly);
        coll.add(key);
        coll.add(hill);
    }

    public ArrayList<Cipher> getColl() {
        return this.coll;
    }

    public SubstitutionCipher getSubCipher() {
        return (SubstitutionCipher) this.coll.get(0);
    }

    public PolyAlphabeticCipher getPolyCipher() {
        return (PolyAlphabeticCipher) this.coll.get(1);
    }

    public PolyAlphabeticDeCipher getPolyDeCipher() {
        return (PolyAlphabeticDeCipher) this.coll.get(2);
    }

    public KeyWordCipher getKeyCipher() {
        return (KeyWordCipher) this.coll.get(3);
    }

    public HillCipher getHillCipher() {
        return (HillCipher) this.coll.get(4);
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
