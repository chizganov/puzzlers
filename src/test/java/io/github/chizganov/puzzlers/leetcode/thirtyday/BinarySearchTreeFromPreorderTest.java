package io.github.chizganov.puzzlers.leetcode.thirtyday;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeFromPreorderTest {

    @ParameterizedTest
    @TestSource(BinarySearchTreeFromPreorder.class)
    void bstFromPreorder(BinarySearchTreeFromPreorder solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            int[] data = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            String expectedResult = out.readLine();
            String actualResult = solution.bstFromPreorder(data).toString();

            assertEquals(expectedResult, actualResult);
        }
    }
}