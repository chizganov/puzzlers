package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class SockMerchantTest {

    private static final String PATH = SockMerchant.class.getName().replace('.', '/') + "/";
    private static final SockMerchant c = new SockMerchant();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test08() {
        test("input08.txt", "output08.txt");
    }

    @SuppressWarnings("Duplicates")
    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            int n = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] ar = new int[n];

            String[] arItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }

            int result = c.sockMerchant(ar);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }
}
