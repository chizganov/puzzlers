package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingBitsTest {

    @ParameterizedTest
    @TestSource(CountingBits.class)
    void countBits(CountingBits solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int num = parseInt(in.readLine());

            int[] expectedResult = Arrays.stream(out.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.countBits(num);

            assertArrayEquals(expectedResult, actualResult, String.format("Input num: %d", num));
        }
    }
}