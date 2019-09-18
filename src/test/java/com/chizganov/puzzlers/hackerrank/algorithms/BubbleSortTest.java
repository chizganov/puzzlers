package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    private static final String PATH = BubbleSort.class.getName().replace('.', '/') + "/";
    private static final BubbleSort s = new BubbleSort();

    private static final String SWAPS_COUNT = "Array is sorted in %d swaps.";
    private static final String FIRST_ELEMENT = "First Element: %d";
    private static final String LAST_ELEMENT = "Last Element: %d";

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test03() {
        test("input03.txt", "output03.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            // Skip unnecessary information
            in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            s.countSwaps(a);
            String result = String.format(
                    String.join("\n", SWAPS_COUNT, FIRST_ELEMENT, LAST_ELEMENT),
                    s.getNumSwaps(),
                    a[0],
                    a[a.length - 1]);
            String expResult = String.join("\n", exp.nextLine(), exp.nextLine(), exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}