package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDigitsTest {

    @ParameterizedTest
    @TestSource(RemoveDigits.class)
    void removeKdigits(RemoveDigits solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String num = in.readLine();
            int k = parseInt(in.readLine());

            String expectedResult = out.readLine();
            String actualResult = solution.removeKdigits(num, k);

            assertEquals(expectedResult, actualResult, String.format("Input: num = %s, k = %d", num, k));
        }
    }
}