package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class ThreeDSurfaceAreaTest {

    private static final String PATH = ThreeDSurfaceArea.class.getName().replace('.', '/') + "/";
    private static final ThreeDSurfaceArea c = new ThreeDSurfaceArea();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test25() {
        test("input25.txt", "output25.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] HW = in.nextLine().split(" ");

            int H = Integer.parseInt(HW[0]);

            int W = Integer.parseInt(HW[1]);

            int[][] A = new int[H][W];

            for (int i = 0; i < H; i++) {
                String[] ARowItems = in.nextLine().split(" ");
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < W; j++) {
                    int AItem = Integer.parseInt(ARowItems[j]);
                    A[i][j] = AItem;
                }
            }

            int result = c.surfaceArea(A);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }

}
