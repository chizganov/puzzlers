package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Boolean.parseBoolean;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationInStringTest {

    @ParameterizedTest
    @TestSource(PermutationInString.class)
    void checkInclusion(PermutationInString solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String string = in.readLine();
            String subStringPermutation = in.readLine();

            boolean expectedResult = parseBoolean(out.readLine().toLowerCase());
            boolean actualResult = solution.checkInclusion(subStringPermutation, string);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: string = '%s', substring permutation = '%s'", string, subStringPermutation));
        }
    }
}