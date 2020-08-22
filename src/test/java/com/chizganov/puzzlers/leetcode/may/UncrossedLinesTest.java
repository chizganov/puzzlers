package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UncrossedLinesTest {

    @ParameterizedTest
    @TestSource(UncrossedLines.class)
    void maxUncrossedLines(UncrossedLines solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] inputA = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] inputB = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

            int[] a = Arrays.copyOf(inputA, inputA.length);
            int[] b = Arrays.copyOf(inputB, inputB.length);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.maxUncrossedLines(a, b);

            assertEquals(expectedResult, actualResult,
                    String.format("Input A = %s, B = %s", Arrays.toString(inputA), Arrays.toString(inputB)));
        }
    }
}