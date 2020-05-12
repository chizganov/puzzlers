package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleElementInSortedArrayTest {

    @ParameterizedTest
    @TestSource(SingleElementInSortedArray.class)
    void singleNonDuplicate(SingleElementInSortedArray solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] nums = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.singleNonDuplicate(nums);

            assertEquals(expectedResult, actualResult, String.format("Input nums: %s", Arrays.toString(nums)));
        }
    }
}