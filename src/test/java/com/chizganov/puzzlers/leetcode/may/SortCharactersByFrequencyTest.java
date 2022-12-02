package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

import static java.nio.file.Files.newBufferedReader;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortCharactersByFrequencyTest {

    @ParameterizedTest
    @TestSource(SortCharactersByFrequency.class)
    void frequencySort(SortCharactersByFrequency solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String inString = in.readLine();

            String actualResult = solution.frequencySort(inString);
            Set<String> expectedResultSet = out.lines().collect(toSet());

            assertTrue(expectedResultSet.contains(actualResult),
                    String.format("\nInput string: %s\nActual output string: %s\nExpected output strings: %s",
                            inString,
                            actualResult,
                            expectedResultSet
                    )
            );
        }
    }
}