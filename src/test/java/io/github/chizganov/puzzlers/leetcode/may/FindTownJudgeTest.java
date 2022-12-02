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

class FindTownJudgeTest {

    @ParameterizedTest
    @TestSource(FindTownJudge.class)
    void findJudge(FindTownJudge solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int n = parseInt(in.readLine());
            int[][] trust = Arrays.stream(in.readLine().replaceAll("(\\[\\[|]])", "").split("],\\["))
                    .map(pair -> Arrays.stream(pair.split(",")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.findJudge(n, trust);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: n = %d, trust = %s", n, Arrays.deepToString(trust)));
        }
    }
}