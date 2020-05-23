package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntervalListIntersectionTest {

    @ParameterizedTest
    @TestSource(IntervalListIntersection.class)
    void intervalIntersection(IntervalListIntersection solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String aLine = in.readLine();
            String bLine = in.readLine();
            int[][] a = parse2dArrayString(aLine);
            int[][] b = parse2dArrayString(bLine);

            int[][] expectedResult = parse2dArrayString(out.readLine());
            int[][] actualResult = solution.intervalIntersection(a, b);

            assertTrue(Arrays.deepEquals(expectedResult, actualResult),
                    String.format("Input: a = %s, b = %s\nExpected result = %s\nActual result = %s",
                            aLine,
                            bLine,
                            Arrays.deepToString(expectedResult),
                            Arrays.deepToString(actualResult)
                    )
            );
        }
    }

    private int[][] parse2dArrayString(String string) {
        return stream(string.replaceAll("(^[^\\d]*|[^\\d]*$)", "").split("],\\["))
                .map(arr -> stream(arr.split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

}