package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlippingBitsTest {

    @ParameterizedTest
    @TestSource(FlippingBits.class)
    void flippingBits(FlippingBits solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            long[] expectedResult = out.lines().mapToLong(Long::parseLong).toArray();
            long[] actualResult = in.lines().mapToLong(Long::parseLong).map(solution::flippingBits).toArray();

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}