package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreedyFloristTest {

    @ParameterizedTest
    @TestSource(GreedyFlorist.class)
    void getMinimumCost(GreedyFlorist solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int k = parseInt(in.readLine().split(" ")[1]);
            int[] costs = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.getMinimumCost(k, costs);
            assertEquals(expectedResult, actualResult);
        }
    }

}