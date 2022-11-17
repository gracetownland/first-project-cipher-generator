package model;

import java.util.ArrayList;

public class SuperCipher {

    private ArrayList<Cipher> coll;

    public SuperCipher() {
        SubstitutionCipher sub = new SubstitutionCipher();
        PolyAlphabeticCipher poly = new PolyAlphabeticCipher();
        PolyAlphabeticDeCipher dePoly = new PolyAlphabeticDeCipher();
        coll = new ArrayList<>();
        coll.add(sub);
        coll.add(poly);
        coll.add(dePoly);
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



    /*
    make method cipher and extend it to every cipher class
    */


    public String cipher() {
        return null;
    }

    //public String getEncryptedMessage(){
    //   return
    //}


}
