package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StockSpannerTest {

    @ParameterizedTest
    @TestSource(StockSpanner.class)
    void next(StockSpanner solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] prices = stream(in.readLine().replaceAll("\\s", "").split(","))
                    .mapToInt(Integer::parseInt).toArray();

            int[] expectedResult = stream(out.readLine().replaceAll("\\s", "").split(","))
                    .mapToInt(Integer::parseInt).toArray();
            int[] actualResult = stream(prices).map(solution::next).toArray();

            assertArrayEquals(expectedResult, actualResult, String.format("Input prices: %s", Arrays.toString(prices)));
        }
    }
}