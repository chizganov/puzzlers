package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllAnagramsTest {

    @ParameterizedTest
    @TestSource(FindAllAnagrams.class)
    void findAnagrams(FindAllAnagrams solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String string = in.readLine();
            String anagram = in.readLine();

            List<Integer> expectedResult = Arrays.stream(out.readLine().replaceAll("[\\[\\]]", "").split(", "))
                    .map(Integer::parseInt).collect(toList());
            List<Integer> actualResult = solution.findAnagrams(string, anagram);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: string = '%s', anagram = '%s'", string, anagram));
        }
    }
}