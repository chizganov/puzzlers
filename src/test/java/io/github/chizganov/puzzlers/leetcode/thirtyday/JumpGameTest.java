package io.github.chizganov.puzzlers.leetcode.thirtyday;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameTest {

    @ParameterizedTest
    @TestSource(JumpGame.class)
    void canJump(JumpGame solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.canJump(nums);

            assertEquals(expectedResult, actualResult);
        }
    }
}