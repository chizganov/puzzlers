package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheTimeInWordsTest {

    private static final String PATH = TheTimeInWords.class.getName().replace('.', '/') + "/";
    private final TheTimeInWords c = new TheTimeInWords();

    @Test void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test void test10() {
        test("input10.txt", "output10.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {
            int h = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int m = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = c.timeInWords(h, m);
            String expectedResult = exp.nextLine();
            assertEquals(expectedResult, result);
        }
    }

}
