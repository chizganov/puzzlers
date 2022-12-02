package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPerfectSquareTest {

    @ParameterizedTest
    @TestSource(ValidPerfectSquare.class)
    void isPerfectSquare(ValidPerfectSquare solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int num = parseInt(in.readLine());

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.isPerfectSquare(num);

            assertEquals(expectedResult, actualResult, String.format("Input num: %d", num));
        }
    }
}