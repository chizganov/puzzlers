package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IceCreamParlorTest {

    @ParameterizedTest
    @TestSource(IceCreamParlor.class)
    void whatFlavors(IceCreamParlor solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int t = Integer.parseInt(in.readLine());

            int[][] actualResult = new int[t][];
            for (int i = 0; i < t; i++) {
                int money = Integer.parseInt(in.readLine());
                in.readLine();
                int[] cost = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                actualResult[i] = solution.whatFlavors(cost, money);
            }

            int[][] expectedResult = out.lines()
                    .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}