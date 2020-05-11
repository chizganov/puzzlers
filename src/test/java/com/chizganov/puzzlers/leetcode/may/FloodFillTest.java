package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.deepEquals;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FloodFillTest {

    @ParameterizedTest
    @TestSource(value = FloodFill.class,
            implementations = {FloodFill.class, FloodFill.RecursiveSolution.class})
    void floodFill(FloodFill solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int[][] image = stream(in.readLine().replaceAll("\\[\\[|]]", "").split("],\\["))
                    .map(line -> stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);
            // Copy of input image used in log
            int[][] inputImage = stream(image).map(row -> stream(row).toArray()).toArray(int[][]::new);

            int[] coordinate = stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int newColor = parseInt(in.readLine());

            int[][] expectedResult = stream(out.readLine().replaceAll("\\[\\[|]]", "").split("],\\["))
                    .map(line -> Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                    .toArray(int[][]::new);
            int[][] actualResult = solution.floodFill(image, coordinate[0], coordinate[1], newColor);

            assertTrue(deepEquals(expectedResult, actualResult),
                    String.format("Input: image = %s, coordinates = %s, newColor = %d\nExpected image: %s\nActual image: %s",
                            Arrays.deepToString(inputImage),
                            Arrays.toString(coordinate),
                            newColor,
                            Arrays.deepToString(expectedResult),
                            Arrays.deepToString(actualResult)));
        }
    }
}