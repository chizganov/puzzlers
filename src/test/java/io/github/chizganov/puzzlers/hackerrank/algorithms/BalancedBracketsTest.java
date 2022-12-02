package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BalancedBracketsTest {

    @ParameterizedTest
    @TestSource(BalancedBrackets.class)
    void isBalanced(BalancedBrackets solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            String[] actualResult = in.lines().map(solution::isBalanced).toArray(String[]::new);
            String[] expectedResult = out.lines().toArray(String[]::new);
            assertArrayEquals(expectedResult, actualResult);
        }
    }

}