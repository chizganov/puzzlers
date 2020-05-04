package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComplementTest {

    @ParameterizedTest
    @TestSource(NumberComplement.class)
    void findComplement(NumberComplement solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int num = parseInt(in.readLine());

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.findComplement(num);

            assertEquals(expectedResult, actualResult, String.format("Input num: %s", num));
        }
    }
}