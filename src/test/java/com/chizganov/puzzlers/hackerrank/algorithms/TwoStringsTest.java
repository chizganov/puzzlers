package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class TwoStringsTest {

    private static final String PATH = TwoStrings.class.getName().replace('.', '/') + "/";
    private static final TwoStrings s = new TwoStrings();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test06() {
        test("input06.txt", "output06.txt");
    }

    @Test
    void test07() {
        test("input07.txt", "output07.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {
            int q = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String s1 = in.nextLine();

                String s2 = in.nextLine();

                String result = s.twoStrings(s1, s2);
                String expResult = exp.nextLine();
                Assertions.assertEquals(expResult, result);
            }
        }
    }

}