package ui;

import model.*;


import java.io.FileNotFoundException;
import java.util.Scanner;

/*

  EFFECTS:runs the application
  */
public class CipherTextGenerator {
    static Scanner sc;


    public CipherTextGenerator() {
        sc = new Scanner(System.in);

        runCipher();
    }

    /*
  REQUIRES: ch is a digit
  MODIFIES: this
  EFFECTS:passes data to respective classes based on user choice
  */
    @SuppressWarnings("methodlength")
    private void runCipher() {
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        while (ch != 5) {
            displayMenu();
            ch = sc.nextInt();
            if (ch == 1) {
                subcipher();
            }
            if (ch == 2) {
                keycipher();
            }
            if (ch == 3) {
                polycipher();
            }
            if (ch == 4) {
                hillcipher();
            }
            if (ch == 5) {
                polydecipher();
            }
            if (ch == 6) {
                subdecipher();
            }
            if (ch == 9) {
                System.out.println("Thx");
                break;
            }
        }
    }

    /*
  EFFECTS:displays menu
  */
    public void displayMenu() {
        System.out.println("Welcome to the Cipher Text Generator");
        System.out.println("Press 1 for a substitution cipher!");
        System.out.println("Press 2 for a keyword cipher!");
        System.out.println("Press 3 for a polyalphabetic cipher!");
        System.out.println("Press 4 for a Hill Cipher!");
        System.out.println("Press 5 for a polyalphabetic decipher");
        System.out.println("Press 6 for a substitution decipher");
        System.out.println("Press 7 to save data");
        System.out.println("Press 8 to load data");
        System.out.println("Press 9 to exit");
        System.out.println("Press any other number to repeat the menu.");
    }
    /*
      MODIFIES: toBeEncrypted,moveBy
      EFFECTS:displays substitution cipher option
      */

    public void subcipher() {
        System.out.println("SUBSTITUTION CIPHER");
        System.out.println("Enter a Sentence");
        String toBeEncrypted = sc.next();
        System.out.println("How much do you want to move by?");
        int moveBy = sc.nextInt();
        System.out.println("Shifting all the letters " + moveBy + " places");
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The encrypted text is ");
        SubstitutionCipher cipher = new SubstitutionCipher(toBeEncrypted, moveBy);
        System.out.println(cipher.getCipher());

    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays keyword cipher option
      */

    public void keycipher() {
        System.out.println("KEYWORD CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();

        System.out.println("Enter a sentence");
        String toBeEncrypted = sc.next();
        System.out.println("Swapping letters of message with keyword array....");
        System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        KeyWordCipher cipher = new KeyWordCipher(keyword, toBeEncrypted);
        System.out.println(cipher.getKeyword());
        System.out.println("The encrypted text is ");
        System.out.println(cipher.cipheredIt());
    }

    /*
         MODIFIES: toBeEncrypted,keyword
         EFFECTS:displays polyalphabetic cipher option
         */
    public void polycipher() {
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        System.out.println("POLYALPHABETIC CIPHER");
        System.out.println("Enter a sentence");
        String toBeEncrypted = sc.next();
        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeEncrypted = toBeEncrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        String key = cipher.keywordgenerator(toBeEncrypted, keyword);
        System.out.println("The Keyword array is" + key);
        String encrypt = cipher.cypher(toBeEncrypted, key);
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The encrypted text is" + encrypt);
    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays hill cipher option
      */

    public void hillcipher() {
        HillCipher cipher = new HillCipher();
        System.out.println("HILL CIPHER");
        System.out.println("Enter a sentence");
        String toBeEncrypted = sc.next();
        System.out.println("enter keyword ");
        String keyword = sc.next();
        System.out.println("The encrypted text is" + cipher.hillCipher(toBeEncrypted, keyword));

    }

    /*
        MODIFIES: toBeEncrypted,keyword
        EFFECTS:displays polyalphabetic decipher option
        */
    public void polydecipher() {
        System.out.println("POLYALPHABETIC DECIPHER");
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        System.out.println("Enter a sentence");
        String toBeDencrypted = sc.next();
        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeDencrypted = toBeDencrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        String key = cipher.keywordgenerator(toBeDencrypted, keyword);
        System.out.println("The Keyword array is" + key);
        String decrypt = cipher.decypher(toBeDencrypted, key);
        System.out.println("The decrypted text is " + decrypt);
    }

    /*
          MODIFIES: toBeEncrypted,keyword
          EFFECTS:displays keyword decipher option
          */
    public void subdecipher() {
        System.out.println("SUBSTITUTION CIPHER");
        System.out.println("Enter a Sentence");
        String toBeEncrypted = sc.next();
        System.out.println("How much do you want to move by?");
        int moveBy = sc.nextInt();
        System.out.println("The decrypted text is ");
        SubstitutionCipher cipher = new SubstitutionCipher(toBeEncrypted, -moveBy);
        System.out.println(cipher.getCipher());
    }


}
