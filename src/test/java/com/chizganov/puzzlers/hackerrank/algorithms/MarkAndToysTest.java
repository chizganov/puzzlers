package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkAndToysTest {

    private static final String PATH = MarkAndToys.class.getName().replace('.', '/') + "/";
    private static final MarkAndToys s = new MarkAndToys();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test16() {
        test("input16.txt", "output16.txt");
    }

    @Test
    void test17() {
        test("input17.txt", "output17.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            String[] nk = in.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] prices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int result = s.maximumToys(prices, k);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}