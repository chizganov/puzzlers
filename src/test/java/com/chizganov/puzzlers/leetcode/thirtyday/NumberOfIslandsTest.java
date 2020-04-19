package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfIslandsTest {

    @ParameterizedTest
    @TestSource(value = NumberOfIslands.class,
            implementations = {NumberOfIslands.class, NumberOfIslands.RecursiveSolution.class})
    void numIslands(NumberOfIslands solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            char[][] grid = in.lines().map(String::toCharArray).toArray(char[][]::new);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.numIslands(grid);

            assertEquals(expectedResult, actualResult);
        }
    }
}