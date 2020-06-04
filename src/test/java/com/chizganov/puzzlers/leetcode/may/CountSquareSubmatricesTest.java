package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSquareSubmatricesTest {

    @ParameterizedTest
    @TestSource(CountSquareSubmatrices.class)
    void countSquares(CountSquareSubmatrices solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[][] matrix = in.lines().map(
                    line -> stream(line.replaceAll("(^[^\\d]*|[^\\d]*$)", "").split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
            String matrixString = Arrays.deepToString(matrix);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.countSquares(matrix);

            assertEquals(expectedResult, actualResult, String.format("Input matrix: %s", matrixString));
        }
    }
}