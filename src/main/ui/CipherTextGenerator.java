package ui;

import model.HillCipher;
import model.KeyWordCipher;
import model.PolyAlphabeticCipher;
import model.SubstitutionCipher;

import java.util.Scanner;

/*

  EFFECTS:runs the application
  */
public class CipherTextGenerator {
    public CipherTextGenerator() {
        runCipher();
    }

    /*
  EFFECTS:displays menu
  */
    public static void displayMenu() {
        System.out.println("Welcome to the Cipher Text Generator");
        System.out.println("Press 1 for a substitution cipher!");
        System.out.println("Press 2 for a keyword cipher!");
        System.out.println("Press 3 for a polyalphabetic cipher!");
        System.out.println("Press 4 for a Hill Cipher!");
        System.out.println("Press 5 for a polyalphabetic decipher");
        System.out.println("Press 6 for a substitution decipher");
        System.out.println("Press 7 to exit");
        System.out.println("Press any other number to repeat the menu.");
    }

    /*
  REQUIRES: ch is a digit
  MODIFIES: this
  EFFECTS:passes data to respective classes based on user choice
  */
    @SuppressWarnings("methodlength")
    private static void runCipher() {
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        while (ch != 5) {
            displayMenu();
            ch = sc.nextInt();
            if (ch == 1) {
                SubstitutionCipher cipher = new SubstitutionCipher();
                System.out.println("SUBSTITUTION CIPHER");
                System.out.println("Enter a Sentence");
                String toBeEncrypted = sc.next();
                System.out.println("How much do you want to move by?");
                int moveBy = sc.nextInt();
                System.out.println("The decrypted text is " + cipher.substitutionCipher(toBeEncrypted, moveBy));
            }
            if (ch == 2) {
                KeyWordCipher cipher = new KeyWordCipher();
                System.out.println("KEYWORD CIPHER");
                System.out.println("enter keyword ");
                String keyword = KeyWordCipher.encoder(sc.next().toCharArray());
                System.out.println("Enter a sentence");
                String toBeEncrypted = sc.next();
                System.out.println("The decrypted text is " + cipher.cipheredIt(toBeEncrypted, keyword));
            }
            if (ch == 3) {
                PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
                System.out.println("POLYALPHABETIC CIPHER");
                System.out.println("Enter a sentence");
                String toBeEncrypted = sc.next();
                System.out.println("enter keyword ");
                String keyword = sc.next();
                toBeEncrypted = toBeEncrypted.toUpperCase();
                keyword = keyword.toUpperCase();
                String key = cipher.keywordgenerator(toBeEncrypted, keyword);
                String encrypt = cipher.cypher(toBeEncrypted, key);
                System.out.println("The encrypted text is" + encrypt);

                System.out.println(toBeEncrypted);
                System.out.println(key);
                System.out.println(encrypt);
                String decrypt = PolyAlphabeticCipher.decypher(encrypt, key);
                System.out.println("The decrypted text is " + decrypt);

            }
            if (ch == 4) {
                HillCipher cipher = new HillCipher();
                System.out.println("HILL CIPHER");
                System.out.println("Enter a sentence");
                String toBeEncrypted = sc.next();
                System.out.println("enter keyword ");
                String keyword = sc.next();
                System.out.println("The encrypted text is" + cipher.hillCipher(toBeEncrypted, keyword));

            }
            if (ch == 5) {
                System.out.println("POLYALPHABETIC DECIPHER");

            }
            if (ch == 7) {
                System.out.println("Thank you");
                break;
            } else {
                continue;
            }
        }
    }
}
