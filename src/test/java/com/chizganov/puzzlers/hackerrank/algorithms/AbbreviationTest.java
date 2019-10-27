package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AbbreviationTest {

    @ParameterizedTest
    @TestSource(Abbreviation.class)
    void abbreviation(Abbreviation solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int q = parseInt(in.readLine());

            String[] actualResult = new String[q];
            String[] expectedResult = out.lines().toArray(String[]::new);

            for (int i = 0; i < q; i++) {
                String a = in.readLine();
                String b = in.readLine();

                actualResult[i] = solution.abbreviation(a, b);
            }

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}