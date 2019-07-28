package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AbsolutePermutationTest {

    private static final String PATH = AbsolutePermutation.class.getName().replace('.', '/') + "/";
    private final AbsolutePermutation ap = new AbsolutePermutation();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test12() {
        test("input12.txt", "output12.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {
            int t = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String expLine;
            StringBuilder strBuilder = new StringBuilder();

            for (int tItr = 0; tItr < t; tItr++) {
                expLine = exp.nextLine();
                strBuilder.setLength(0);

                String[] nk = in.nextLine().split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                int[] result = ap.absolutePermutation(n, k);

                for (int i = 0; i < result.length; i++) {
                    strBuilder.append(result[i]);

                    if (i != result.length - 1) {
                        strBuilder.append(" ");
                    }
                }

                assertEquals(expLine, strBuilder.toString());
            }
        }
    }

}
