package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MaximumXorTest {

    @ParameterizedTest
    @TestSource(MaximumXor.class)
    void maxXor(MaximumXor solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            in.readLine();
            int[] queries = in.lines().mapToInt(Integer::parseInt).toArray();

            int[] expectedResult = out.lines().map(String::trim).mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.maxXor(arr, queries);

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}