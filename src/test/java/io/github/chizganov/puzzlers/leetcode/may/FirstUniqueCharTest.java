package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharTest {

    @ParameterizedTest
    @TestSource(FirstUniqueChar.class)
    void firstUniqChar(FirstUniqueChar solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String s = in.readLine();

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.firstUniqChar(s);

            assertEquals(expectedResult, actualResult, String.format("Input string: %s", s));
        }
    }
}