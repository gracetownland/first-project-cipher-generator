package model;

public class HillCipher {
    public static void getMatrixKey(String keyword, int[][] matrixKey) {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrixKey[i][j] = (keyword.charAt(a)) % 65;
                a++;
            }
        }
    }

    public static void encrypt(int[][] matrixCipher, int[][] matrixKey, int[][] message) {
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

    public static String hillCipher(String encrypt, String keyword) {
        int[][] matrixKey = new int[5][5];
        getMatrixKey(keyword, matrixKey);
        int[][] message = new int[5][1];
        for (int i = 0; i < 5; i++) {
            message[i][0] = (encrypt.charAt(i)) % 65;
        }
        int[][] matrixCipher = new int[5][1];
        encrypt(matrixCipher, matrixKey, message);
        String cipherText = "";
        for (int i = 0; i < 5; i++) {
            cipherText += (char) (matrixCipher[i][0] + 65);
        }
        return cipherText;
    }
}

