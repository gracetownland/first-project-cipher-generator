package model;
/*Each letter is represented as a number%26.
encrypting a message-> each block of n letters is multiplied by n*n matrix %26. */



import java.util.Collections;
import java.util.List;

public class HillCipher extends MasterCipher {





    /*  MODIFIES: this
     *   EFFECTS:key matrix is genetated*/
    public void getMatrixKey(String keyword, int[][] matrixKey) {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrixKey[i][j] = (keyword.charAt(a)) % 65;
                a++;
            }
        }
    }

    /*
        MODIFIES:this
        EFFECTS: encrypts the message using matrixKey
     */
    public void encrypt(int[][] matrixCipher, int[][] matrixKey, int[][] message) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                matrixCipher[i][j] = 0;
                for (int k = 0; k < 5; k++) {
                    matrixCipher[i][j] += matrixKey[i][k] * message[k][j];
                }
                matrixCipher[i][j] = matrixCipher[i][j] % 26;
            }
        }
    }

    /*
           MODIFIES:this
           EFFECTS: implements Hill Cipher
        */
    public String hillCipher(String encrypt, String keyword) {
        int[][] matrixKey = new int[5][5];
        getMatrixKey(keyword, matrixKey);
        int[][] message = new int[5][1];
        for (int i = 0; i < 5; i++) {
            message[i][0] = (encrypt.charAt(i)) % 65;
        }
        int[][] matrixCipher = new int[5][1];
        encrypt(matrixCipher, matrixKey, message);
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            cipherText.append((char) (matrixCipher[i][0] + 65));
        }
        return cipherText.toString();
    }


}

