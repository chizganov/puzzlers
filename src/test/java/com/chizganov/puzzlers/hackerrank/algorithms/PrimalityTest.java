package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PrimalityTest {

    @ParameterizedTest
    @TestSource(Primality.class)
    void test(Primality solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            String[] expectedResult = out.lines().toArray(String[]::new);
            String[] actualResult = in.lines().mapToInt(Integer::parseInt).mapToObj(solution::primality).toArray(String[]::new);

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}