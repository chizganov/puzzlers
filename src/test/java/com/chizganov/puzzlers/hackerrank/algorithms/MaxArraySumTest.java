package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxArraySumTest {

    private static MaxArraySum solution = new MaxArraySum();

    @ParameterizedTest
    @TestSource(MaxArraySum.class)
    void maxSubsetSum(Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
            BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int actualResult = solution.maxSubsetSum(arr);
            int expectedResult = parseInt(out.readLine());
            assertEquals(expectedResult, actualResult);
        }
    }

}