package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumberTest {

    @ParameterizedTest
    @TestSource(HappyNumber.class)
    void isHappy(HappyNumber solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int num = parseInt(in.readLine());

            boolean expectedResult = Boolean.parseBoolean(out.readLine());
            boolean actualResult = solution.isHappy(num);

            assertEquals(expectedResult, actualResult);
        }
    }
}