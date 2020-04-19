package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumPathSumTest {

    @ParameterizedTest
    @TestSource(MinimumPathSum.class)
    void minPathSum(MinimumPathSum solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[][] grid = in.lines().map(
                    line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()
            ).toArray(int[][]::new);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.minPathSum(grid);

            assertEquals(expectedResult, actualResult);
        }
    }
}