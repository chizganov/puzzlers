package com.chizganov.puzzlers.hackerrank.euler;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LargestPrimeFactorTest {

    @ParameterizedTest
    @TestSource(LargestPrimeFactor.class)
    void largestPrimeFactor(LargestPrimeFactor solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            long[] expectedResult = out.lines().mapToLong(Long::parseLong).toArray();
            long[] actualResult = in.lines().mapToLong(Long::parseLong).map(solution::largestPrimeFactor).toArray();

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}