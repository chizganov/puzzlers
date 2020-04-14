package com.chizganov.puzzlers.leetcode;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @ParameterizedTest
    @TestSource(TwoSum.class)
    void twoSum(TwoSum solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = parseInt(in.readLine());

            int[] expectedResult = Arrays.stream(out.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.twoSum(nums, target);

            assertArrayEquals(expectedResult, actualResult);
        }
    }
}