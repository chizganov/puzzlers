package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesisStringTest {

    @ParameterizedTest
    @TestSource(value = ValidParenthesisString.class,
            implementations = {ValidParenthesisString.class, ValidParenthesisString.GreedyEffectiveSolution.class})
    void checkValidString(ValidParenthesisString solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            String line = in.readLine();

            boolean expectedResult = "True".equals(out.readLine());
            boolean actualResult = solution.checkValidString(line);

            assertEquals(expectedResult, actualResult);
        }
    }
}