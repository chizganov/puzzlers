package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CandiesTest {

    @ParameterizedTest
    @TestSource(Candies.class)
    void candies(Candies solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();
            int[] data = in.lines().mapToInt(Integer::parseInt).toArray();

            long expectedResult = parseInt(out.readLine());
            long actualResult = solution.candies(data);
            assertEquals(expectedResult, actualResult);
        }
    }

}