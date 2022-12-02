package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContiguousArrayTest {

    @ParameterizedTest
    @TestSource(ContiguousArray.class)
    void findMaxLength(ContiguousArray solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[] inputArr = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] nums = Arrays.copyOf(inputArr, inputArr.length);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.findMaxLength(nums);

            assertEquals(expectedResult, actualResult, String.format("Input array: %s", Arrays.toString(inputArr)));
        }
    }
}