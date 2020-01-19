package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FriendCircleQueriesTest {

    @ParameterizedTest
    @TestSource(FriendCircleQueries.class)
    void maxCircle(FriendCircleQueries solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            int[][] queries = in.lines().map(line -> line.split(" "))
                    .map(lineArr -> new int[]{parseInt(lineArr[0]), parseInt(lineArr[1])})
                    .toArray(int[][]::new);

            int[] expectedResult = out.lines().mapToInt(Integer::parseInt).toArray();
            int[] actualResult = solution.maxCircle(queries);

            assertArrayEquals(expectedResult, actualResult);
        }
    }

}