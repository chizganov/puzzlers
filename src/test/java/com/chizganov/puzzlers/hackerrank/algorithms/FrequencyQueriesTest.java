package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyQueriesTest {

    private static FrequencyQueries s = new FrequencyQueries();

    @ParameterizedTest
    @TestSource(FrequencyQueries.class)
    void freqQuery(Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            in.readLine();

            List<int[]> queries = in.lines()
                    .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .collect(toList());

            List<Integer> actualResult = s.freqQuery(queries);
            List<Integer> expectedResult = out.lines().mapToInt(Integer::parseInt).boxed().collect(toList());
            assertEquals(expectedResult, actualResult);
        }
    }

}