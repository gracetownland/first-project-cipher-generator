package ui;

import model.HillCipher;
import model.KeyWordCipher;
import model.PolyAlphabeticCipher;
import model.SubstitutionCipher;
import org.json.JSONArray;
import org.json.JSONObject;

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
        ArrayList<String> listInput = buildUserInput();
        ArrayList<String> listOutput = buildUserOutput();
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
            if (ch == 7) {
                System.out.println("Thank you");
                break;
            }
            if (ch == 8) {
                System.out.println(listInput.toString());
            }
            if (ch == 9) {
                System.out.println(listOutput.toString());
            }

        } while (ch != 5);


        JSONObject obj = new JSONObject();
        obj.put("UI", listInput);
        obj.put("OUT", listOutput);
        PrintWriter print;
        try {
            print = new PrintWriter("./data/data2.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        print.print(obj.toString(4));
        print.close();
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    public ArrayList buildUserInput() {
        ArrayList<String> in = new ArrayList<>();
        String json = null;
        try {
            json = readFile("./data/data2.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject o = new JSONObject(json);
        JSONArray a = new JSONArray(o.getJSONArray("UI"));
        for (Object j : a) {

            in.add(j.toString());
        }
        return in;
    }

    public ArrayList buildUserOutput() {
        ArrayList<String> out = new ArrayList<>();
        String json = null;
        try {
            json = readFile("./data/data2.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject o = new JSONObject(json);
        JSONArray a = new JSONArray(o.getJSONArray("OUT"));
        for (Object j : a) {

            out.add(j.toString());
        }
        return out;
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
        System.out.println("Press 8 to see user input");
        System.out.println("Press any other number to repeat the menu.");
    }
    /*
      MODIFIES: toBeEncrypted,moveBy
      EFFECTS:displays substitution cipher option
      */

    public String subcipher(String toBeEncrypted) {
        SubstitutionCipher cipher = new SubstitutionCipher();
        System.out.println("SUBSTITUTION CIPHER");

        System.out.println("How much do you want to move by?");
        int moveBy = sc.nextInt();
        System.out.println("Shifting all the letters " + moveBy + " places");
        System.out.println("The original text is " + toBeEncrypted);
        System.out.println("The encrypted text is " + cipher.substitutionCipher(toBeEncrypted, moveBy));
        return cipher.substitutionCipher(toBeEncrypted, moveBy);
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
    public String subdecipher(String toBeEncrypted) {
        SubstitutionCipher cipher = new SubstitutionCipher();
        System.out.println("SUBSTITUTION CIPHER");
        System.out.println("How much do you want to move by?");
        int moveBy = sc.nextInt();
        System.out.println("The decrypted text is " + cipher.substitutionCipher(toBeEncrypted, -moveBy));
        return cipher.substitutionCipher(toBeEncrypted, -moveBy);
    }


    public void acceptInput() {
        System.out.println("Enter a Sentence");
        toBeEncrypted = sc.next();
    }

}
