package io.github.chizganov.puzzlers.leetcode.thirtyday;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeftmostColumnTest {

    @ParameterizedTest
    @TestSource(value = LeftmostColumn.class,
            implementations = {LeftmostColumn.class, LeftmostColumn.OptimalSolution.class})
    void leftMostColumnWithOne(LeftmostColumn solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[][] matrix = in.lines().map(
                    line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()
            ).toArray(int[][]::new);

            LeftmostColumn.BinaryMatrix bm = new LeftmostColumn.BinaryMatrix(matrix);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.leftMostColumnWithOne(bm);

            assertEquals(expectedResult, actualResult);
        }
    }
}