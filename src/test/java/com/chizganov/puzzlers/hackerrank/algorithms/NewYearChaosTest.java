package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class NewYearChaosTest {

    private static final String PATH = NewYearChaos.class.getName().replace('.', '/') + "/";
    private static final NewYearChaos s = new NewYearChaos();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test11() {
        test("input11.txt", "output11.txt");
    }

    @SuppressWarnings("Duplicates")
    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int t = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = in.nextInt();
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] q = new int[n];

                String[] qItems = in.nextLine().split(" ");
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }

                int r = s.minimumBribes(q);
                String result = r == -1 ? "Too chaotic" : Integer.toString(r);
                String expResult = exp.nextLine();
                Assertions.assertEquals(expResult, result);
            }
        }
    }

}
