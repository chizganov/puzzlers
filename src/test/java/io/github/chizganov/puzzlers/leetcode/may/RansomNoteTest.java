package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Boolean.parseBoolean;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {

    @ParameterizedTest
    @TestSource(RansomNote.class)
    void canConstruct(RansomNote solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String note = in.readLine();
            String magazine = in.readLine();

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.canConstruct(note, magazine);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: note \"%s\", magazine \"%s\"", note, magazine));
        }
    }
}