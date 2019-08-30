package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class CountingValleysTest {

    private static final String PATH = CountingValleys.class.getName().replace('.', '/') + "/";
    private static final CountingValleys c = new CountingValleys();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @SuppressWarnings("unused")
    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            int n = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s = in.nextLine();

            int result = c.countingValleys(s);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }

}
