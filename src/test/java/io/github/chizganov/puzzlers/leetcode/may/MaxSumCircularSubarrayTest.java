package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumCircularSubarrayTest {

    @ParameterizedTest
    @TestSource(MaxSumCircularSubarray.class)
    void maxSubarraySumCircular(MaxSumCircularSubarray solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String arrayString = in.readLine();
            int[] array = Arrays.stream(arrayString.split(",")).mapToInt(Integer::parseInt).toArray();

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.maxSubarraySumCircular(array);

            assertEquals(expectedResult, actualResult, String.format("Input array: %s", arrayString));
        }
    }
}