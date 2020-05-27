package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PossibleBipartitionTest {

    @ParameterizedTest
    @TestSource(PossibleBipartition.class)
    void possibleBipartition(PossibleBipartition solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int n = parseInt(in.readLine());
            String dislikesString = in.readLine();
            int[][] dislikes = stream(dislikesString.replaceAll("(^[^\\d]*|[^\\d]*$)", "").split("],\\["))
                    .map(arr -> stream(arr.split(",")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.possibleBipartition(n, dislikes);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: n = %s, dislikes = %s", n, Arrays.deepToString(dislikes)));
        }
    }
}