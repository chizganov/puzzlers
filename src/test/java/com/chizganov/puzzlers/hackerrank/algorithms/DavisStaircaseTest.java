package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DavisStaircaseTest {

    @ParameterizedTest
    @TestSource(DavisStaircase.class)
    void stepPerms(DavisStaircase solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            int[] nums = in.lines().mapToInt(Integer::parseInt).toArray();

            int[] expectedResult = out.lines().mapToInt(Integer::parseInt).toArray();
            int[] actualResult = new int[nums.length];
            for (int i = 0; i < nums.length; i++) actualResult[i] = solution.stepPerms(nums[i]);

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}