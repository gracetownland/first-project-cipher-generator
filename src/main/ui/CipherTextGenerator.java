package ui;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/*

  EFFECTS:runs the application
  */
public class CipherTextGenerator {
    static Scanner sc = new Scanner(System.in);
    String toBeEncrypted;
    private String json;
    JsonReader reader = new JsonReader("./data/data2.json");
    JsonWriter writer = new JsonWriter("./data/data2.json");

    public CipherTextGenerator() {
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
        ArrayList<String> listInput = reader.buildUserInput();
        ArrayList<SuperCipher> listOutput = reader.buildUserOutput();
        Scanner sc = new Scanner(System.in);
        do {
            displayMenu();
            ch = sc.nextInt();
            sc.nextLine();
            //acceptInput();
            if (ch == 1) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(subcipher(toBeEncrypted));
            }
//            if (ch == 2) {
//                acceptInput();
//                listInput.add(toBeEncrypted);
//                listOutput.add(keycipher(toBeEncrypted));
//
//            }
//            if (ch == 3) {
//                acceptInput();
//                listInput.add(toBeEncrypted);
//                listOutput.add(polycipher(toBeEncrypted));
//            }
//            if (ch == 4) {
//                acceptInput();
//                listInput.add(toBeEncrypted);
//                listOutput.add(hillcipher(toBeEncrypted));
//            }
//            if (ch == 5) {
//                acceptInput();
//                listInput.add(toBeEncrypted);
//                listOutput.add(polydecipher(toBeEncrypted));
//            }
//            if (ch == 6) {
//                acceptInput();
//                listInput.add(toBeEncrypted);
//                listOutput.add(subdecipher(toBeEncrypted));
//            }
//            if (ch == 7) {
//                System.out.println("Thank you");
//                break;
//            }
//            if (ch == 8) {
//                System.out.println(listInput.toString());
//            }
//            if (ch == 9) {
//                System.out.println(listOutput.toString());
//            }

        } while (ch != 7);
        writer.write(listInput, listOutput);
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
        System.out.println("Press 7 to exit");
        System.out.println("Press 8 to see user input history");
        System.out.println("Press 9 to see user output history");

        System.out.println("Press any other number to repeat the menu.");
    }
    /*
      MODIFIES: toBeEncrypted,moveBy
      EFFECTS:displays substitution cipher option
      */

    public SubstitutionCipher subcipher(String toBeEncrypted) {
        // SubstitutionCipher cipher = new SubstitutionCipher();
        System.out.println("SUBSTITUTION CIPHER");

        System.out.println("How much do you want to move by?");
        String moveBy = sc.next();
        System.out.println("Shifting all the letters " + moveBy + " places");
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The encrypted text is " + new SubstitutionCipher(toBeEncrypted, moveBy));

        return new SubstitutionCipher(toBeEncrypted, moveBy);
    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays keyword cipher option
      */

    public String keycipher(String toBeEncrypted) {
        KeyWordCipher cipher = new KeyWordCipher();
        System.out.println("KEYWORD CIPHER");
        System.out.println("enter keyword ");
        String keyword = cipher.encoder(sc.next().toCharArray());
        System.out.println("The Keyword array is" + keyword);

        System.out.println("Swapping letters of message with keyword array....");
        System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(keyword);
        System.out.println("The encrypted text is " + cipher.cipheredIt(toBeEncrypted, keyword));
        return cipher.cipheredIt(toBeEncrypted, keyword);
    }

    /*
         MODIFIES: toBeEncrypted,keyword
         EFFECTS:displays polyalphabetic cipher option
         */
    public String polycipher(String toBeEncrypted) {
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        System.out.println("POLYALPHABETIC CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeEncrypted = toBeEncrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        String key = cipher.keywordgenerator(toBeEncrypted, keyword);
        System.out.println("The Keyword array is" + key);
        String encrypt = cipher.cypher(toBeEncrypted, key);
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The encrypted text is" + encrypt);
        return encrypt;
    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays hill cipher option
      */

    public String hillcipher(String toBeEncrypted) {
        HillCipher cipher = new HillCipher();
        System.out.println("HILL CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        System.out.println("The encrypted text is" + cipher.hillCipher(toBeEncrypted, keyword));
        return cipher.hillCipher(toBeEncrypted, keyword);
    }

    /*
        MODIFIES: toBeEncrypted,keyword
        EFFECTS:displays polyalphabetic decipher option
        */
    public String polydecipher(String toBeDencrypted) {
        System.out.println("POLYALPHABETIC DECIPHER");
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();

        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeDencrypted = toBeDencrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        String key = cipher.keywordgenerator(toBeDencrypted, keyword);
        System.out.println("The Keyword array is" + key);
        String decrypt = cipher.decypher(toBeDencrypted, key);
        System.out.println("The decrypted text is " + decrypt);
        return decrypt;
    }

    /*
          MODIFIES: toBeEncrypted,keyword
          EFFECTS:displays keyword decipher option
          */
    public SubstitutionCipher subdecipher(String toBeEncrypted) {
        //SubstitutionCipher cipher = new SubstitutionCipher();
        System.out.println("SUBSTITUTION CIPHER");
        System.out.println("How much do you want to move by?");
        int moveBy = -sc.nextInt();
        System.out.println("The decrypted text is " + new SubstitutionCipher(toBeEncrypted, Integer.toString(moveBy)));
        return new SubstitutionCipher(toBeEncrypted, Integer.toString(moveBy));
    }


    public void acceptInput() {
        System.out.println("Enter a Sentence");
        toBeEncrypted = sc.next();
    }

}
