package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @TestSource(value = SearchInRotatedSortedArray.class)
    void search(SearchInRotatedSortedArray solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = parseInt(in.readLine());

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.search(nums, target);

            assertEquals(expectedResult, actualResult);
        }
    }
}