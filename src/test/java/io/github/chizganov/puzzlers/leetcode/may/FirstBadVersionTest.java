package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstBadVersionTest {

    @ParameterizedTest
    @TestSource(FirstBadVersion.class)
    void firstBadVersion(FirstBadVersion solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            int versionsNumber = parseInt(in.readLine());
            int firstBadVersion = parseInt(in.readLine());
            solution.setFirstBadVersions(firstBadVersion);
            solution.setVersionsNumber(versionsNumber);

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.firstBadVersion(versionsNumber);

            assertEquals(expectedResult, actualResult);
        }
    }
}