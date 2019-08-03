package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class BiggerIsGreaterTest {

    private static final String PATH = BiggerIsGreater.class.getName().replace('.', '/') + "/";
    private static final BiggerIsGreater c = new BiggerIsGreater();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test04() {
        test("input04.txt", "output04.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            int T = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int TItr = 0; TItr < T; TItr++) {
                String w = in.nextLine();

                String result = c.biggerIsGreater(w);
                String expResult = exp.nextLine();

                Assertions.assertEquals(expResult, result);
            }
        }
    }

}
