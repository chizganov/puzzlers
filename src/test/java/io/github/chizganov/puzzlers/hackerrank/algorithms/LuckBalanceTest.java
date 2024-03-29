package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckBalanceTest {

    @ParameterizedTest
    @TestSource(LuckBalance.class)
    void luckBalance(LuckBalance solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int k = Integer.parseInt(in.readLine().split(" ")[1]);

            int[][] contests = in.lines()
                    .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);

            int actualResult = solution.luckBalance(k, contests);
            int expectedResult = Integer.parseInt(out.readLine());
            assertEquals(expectedResult, actualResult);
        }
    }

}