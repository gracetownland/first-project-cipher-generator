package model;

public class HillCipher {
    public static void getMatrixKey(String keyword, int[][] matrixKey) {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixKey[i][j] = (keyword.charAt(a)) % 65;
                a++;
            }
        }
    }

    public static void encrypt(int[][] matrixCipher, int[][] matrixKey, int[][] message) {


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                matrixCipher[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    matrixCipher[i][j] += matrixKey[i][k] * message[k][j];
                }
                matrixCipher[i][j] = matrixCipher[i][j] % 26;
            }
        }
    }

    public static void hillCipher(String encrypt, String keyword) {
        int[][] matrixKey = new int[3][3];
        getMatrixKey(keyword, matrixKey);
        int[][] message = new int[3][1];
        for (int i = 0; i < 3; i++) {
            message[i][0] = (encrypt.charAt(i)) % 65;
        }
        int[][] matrixCipher = new int[3][1];


        encrypt(matrixCipher, matrixKey, message);

        String cipherText = "";


        for (int i = 0; i < 3; i++) {
            cipherText += (char) (matrixCipher[i][0] + 65);
        }
        // Finally print the ciphertext
        System.out.print(" Ciphertext:" + cipherText);
    }
}

