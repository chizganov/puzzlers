package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckStraightLineTest {

    @ParameterizedTest
    @TestSource(CheckStraightLine.class)
    void checkStraightLine(CheckStraightLine solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[][] coordinates = Arrays.stream(in.readLine().replaceAll("(\\[\\[|]])", "").split("],\\["))
                    .map(line -> Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.checkStraightLine(coordinates);

            assertEquals(expectedResult, actualResult,
                    String.format("Input coordinates: %s", Arrays.deepToString(coordinates)));
        }
    }
}