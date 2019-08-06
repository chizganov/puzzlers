package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class RepeatedStringTest {

    private static final String PATH = RepeatedString.class.getName().replace('.', '/') + "/";
    private static final RepeatedString c = new RepeatedString();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String s = in.nextLine();

            long n = in.nextLong();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = c.repeatedString(s, n);
            long expResult = Long.parseLong(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }

}
