package io.github.chizganov.puzzlers.leetcode;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortedSquaresArrayTest {

    @ParameterizedTest
    @TestSource(SortedSquaresArray.class)
    void sortedSquares(SortedSquaresArray solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] inputArray = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] a = Arrays.copyOf(inputArray, inputArray.length);

            int[] expectedResult = Arrays.stream(out.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.sortedSquares(a);

            assertArrayEquals(expectedResult, actualResult,
                    String.format("Input array: %s\nExpected result: %s\nActual result: %s\n",
                            Arrays.toString(inputArray),
                            Arrays.toString(expectedResult),
                            Arrays.toString(actualResult)));
        }
    }
}