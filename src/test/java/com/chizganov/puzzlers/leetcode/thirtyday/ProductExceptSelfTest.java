package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductExceptSelfTest {

    @ParameterizedTest
    @TestSource(ProductExceptSelf.class)
    void productExceptSelf(ProductExceptSelf solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] expectedResult = Arrays.stream(out.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.productExceptSelf(nums);

            assertArrayEquals(expectedResult, actualResult);
        }
    }
}