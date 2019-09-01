package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

class ArrayLeftRotationTest {

    private static final String PATH = ArrayLeftRotation.class.getName().replace('.', '/') + "/";
    private static final ArrayLeftRotation s = new ArrayLeftRotation();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test10() {
        test("input10.txt", "output10.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] nd = in.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            int d = Integer.parseInt(nd[1]);

            int[] a = new int[n];

            String[] aItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            int[] result = s.rotLeft(a, d);
            int[] expResult = Arrays.stream(exp.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Assertions.assertArrayEquals(expResult, result);
        }
    }

}
