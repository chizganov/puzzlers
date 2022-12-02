package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayLeftRotationTest {

    @ParameterizedTest
    @TestSource(ArrayLeftRotation.class)
    void rotLeft(ArrayLeftRotation solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
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

            int[] result = solution.rotLeft(a, d);
            int[] expResult = Arrays.stream(exp.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assertArrayEquals(expResult, result);
        }
    }

}
