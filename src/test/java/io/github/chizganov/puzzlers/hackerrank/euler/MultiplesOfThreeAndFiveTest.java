package io.github.chizganov.puzzlers.hackerrank.euler;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplesOfThreeAndFiveTest {

    @ParameterizedTest
    @TestSource(MultiplesOfThreeAndFive.class)
    void multiples(MultiplesOfThreeAndFive solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            long[] expectedResult = out.lines().mapToLong(Integer::parseInt).toArray();
            long[] actualResult = in.lines().mapToInt(Integer::parseInt).mapToLong(solution::multiples).toArray();

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}