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

class MergeSortTest {

    private static MergeSort s = new MergeSort();

    @ParameterizedTest
    @TestSource(value = MergeSort.class/*, pattern = "^[a-zA-Z]+01.txt$"*/)
    void countInversions(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {

            int d = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr;
            for (int i = 0; i < d; i++) {
                in.skip("\\d+(\r\n|[\n\r\u2028\u2029\u0085])?");
                arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                long actualResult = s.countInversions(arr);
                long expectedResult = out.nextLong();
                assertEquals(expectedResult, actualResult);
            }
        }
    }

}