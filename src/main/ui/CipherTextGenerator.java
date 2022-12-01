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
    SuperCipher superCipher = new SuperCipher();

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
        ArrayList<String> listOutput = reader.buildUserOutput();
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
            if (ch == 2) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(keycipher(toBeEncrypted));

            }
            if (ch == 3) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(polycipher(toBeEncrypted));
            }
            if (ch == 4) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(hillcipher(toBeEncrypted));
            }
            if (ch == 5) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(polydecipher(toBeEncrypted));
            }
            if (ch == 6) {
                acceptInput();
                listInput.add(toBeEncrypted);
                listOutput.add(subdecipher(toBeEncrypted));
            }
            if (ch == 10) {
                System.out.println("Thank you");
                break;
            }
            if (ch == 8) {
                System.out.println(listInput.toString());
            }
            if (ch == 9) {
                System.out.println(listOutput.toString());
            }
            if (ch == 7) {
                writer.write(listInput, listOutput);
            }

        } while (ch != 10);
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
        System.out.println("Press 7 to save data!");
        System.out.println("Press 8 to see user input history");
        System.out.println("Press 9 to see user output history");
        System.out.println("Press 10 exit!");
        System.out.println("Press any other number to repeat the menu.");
    }
    /*
      MODIFIES: toBeEncrypted,moveBy
      EFFECTS:displays substitution cipher option
      */

    public String subcipher(String toBeEncrypted) {
        System.out.println("SUBSTITUTION CIPHER");
        System.out.println("How much do you want to move by?");
        String moveBy = sc.next();
        System.out.println("Shifting all the letters " + moveBy + " places");
        System.out.println("The original text is " + toBeEncrypted);
        int i = superCipher.addSubCipher();
        superCipher.getSubCipher(i).setAll(toBeEncrypted,moveBy);
        String result = superCipher.getSubCipher(i).cipher();
        System.out.println("The encrypted text is " + result);
        return result;
    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays keyword cipher option
      */

    public String keycipher(String toBeEncrypted) {
        int i = superCipher.addKeyCipher();
        System.out.println("KEYWORD CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        superCipher.getKeyCipher(i).setAll(toBeEncrypted, keyword);
        System.out.println("The Keyword array is" + superCipher.getKeyCipher(i).getEncoded());
        System.out.println("Swapping letters of message with keyword array....");
        System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(superCipher.getKeyCipher(i).getEncoded());
        String result = superCipher.getKeyCipher(i).cipher();
        System.out.println("The encrypted text is " + result);
        return result;
    }

    /*
         MODIFIES: toBeEncrypted,keyword
         EFFECTS:displays polyalphabetic cipher option
         */
    public String polycipher(String toBeEncrypted) {
        //PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        System.out.println("POLYALPHABETIC CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeEncrypted = toBeEncrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        System.out.println("The original text is " + toBeEncrypted);
        int i = superCipher.addPolyCipher();
        superCipher.getPolyCipher(i).setAll(toBeEncrypted, keyword);
        System.out.println("The keyword array is " + superCipher.getPolyCipher(i).keywordgenerator());
        String result = superCipher.getPolyCipher(i).cipher();
        System.out.println("The encrypted text is" + result);
        return result;
    }
 /*
      MODIFIES: toBeEncrypted,keyword
      EFFECTS:displays hill cipher option
      */

    public String hillcipher(String toBeEncrypted) {
        int i = superCipher.addHillCipher();
        System.out.println("HILL CIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        superCipher.getHillCipher(i).setAll(toBeEncrypted, keyword);
        String result = superCipher.getHillCipher(i).cipher();
        System.out.println("The encrypted text is" + result);
        return result;
    }

    /*
        MODIFIES: toBeEncrypted,keyword
        EFFECTS:displays polyalphabetic decipher option
        */

    public String polydecipher(String toBeDencrypted) {
        System.out.println("POLYALPHABETIC DECIPHER");
        System.out.println("enter keyword ");
        String keyword = sc.next();
        toBeDencrypted = toBeDencrypted.toUpperCase();
        keyword = keyword.toUpperCase();
        System.out.println("The original text is " + toBeDencrypted);
        int i = superCipher.addPolyDecipher();
        superCipher.getPolyDeCipher(i).setAll(toBeDencrypted, keyword);
        System.out.println("The keyword array is " + superCipher.getPolyDeCipher(i).keywordgenerator());
        String result = superCipher.getPolyDeCipher(i).cipher();
        System.out.println("The encrypted text is" + result);
        return result;
    }

    /*
          MODIFIES: toBeEncrypted,keyword
          EFFECTS:displays keyword decipher option
          */
    public String subdecipher(String toBeEncrypted) {

        System.out.println("SUBSTITUTION DECIPHER");
        System.out.println("How much do you want to move by?");
        String moveBy = Integer.toString(-sc.nextInt());
        System.out.println("Shifting all the letters " + moveBy + " places");
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The original text is " + toBeEncrypted);
        int i = superCipher.addSubCipher();
        String result = superCipher.getSubCipher(i).cipher();
        System.out.println("The encrypted text is " + result);
        return result;
    }


    public void acceptInput() {
        System.out.println("Enter a Sentence");
        toBeEncrypted = sc.next();
    }

}
