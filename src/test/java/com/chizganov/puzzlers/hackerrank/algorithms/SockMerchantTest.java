package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SockMerchantTest {

    @ParameterizedTest
    @TestSource(SockMerchant.class)
    void sockMerchant(SockMerchant solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
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

            int result = solution.sockMerchant(ar);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }
}
