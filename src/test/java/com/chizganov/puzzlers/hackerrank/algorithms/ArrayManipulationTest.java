package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayManipulationTest {

    private static ArrayManipulation s = new ArrayManipulation();

    @ParameterizedTest
    @TestSource(ArrayManipulation.class)
    void arrayManipulation(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {

            int n = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int m = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] queries = new int[m][3];
            while (m-- > 0) queries[m] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long actualResult = s.arrayManipulation(n, queries);
            long expectedResult = out.nextLong();
            assertEquals(expectedResult, actualResult);
        }
    }

}