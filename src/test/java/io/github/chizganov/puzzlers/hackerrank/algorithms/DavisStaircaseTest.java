package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DavisStaircaseTest {

    @ParameterizedTest
    @TestSource(DavisStaircase.class)
    void stepPerms(DavisStaircase solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            int[] expectedResult = out.lines().mapToInt(Integer::parseInt).toArray();
            int[] actualResult = in.lines().mapToInt(Integer::parseInt).map(solution::stepPerms).toArray();

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}