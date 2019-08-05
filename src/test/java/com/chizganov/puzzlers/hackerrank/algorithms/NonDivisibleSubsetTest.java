package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class NonDivisibleSubsetTest {

    private static final String PATH = NonDivisibleSubset.class.getName().replace('.', '/') + "/";
    private static final NonDivisibleSubset c = new NonDivisibleSubset();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test16() {
        test("input16.txt", "output16.txt");
    }

    @SuppressWarnings("Duplicates")
    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] nk = in.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] S = new int[n];

            String[] SItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int SItem = Integer.parseInt(SItems[i]);
                S[i] = SItem;
            }

            int result = c.nonDivisibleSubset(k, S);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }

}
