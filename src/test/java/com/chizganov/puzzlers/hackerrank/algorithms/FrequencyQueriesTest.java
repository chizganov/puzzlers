package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyQueriesTest {

    private static FrequencyQueries s = new FrequencyQueries();

    @ParameterizedTest
    @TestSource(FrequencyQueries.class)
    void freqQuery(Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input) ;
             BufferedReader out = Files.newBufferedReader(output)) {
            int q = Integer.parseInt(in.readLine().trim());

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(
                            Stream.of(in.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> actualResult = s.freqQuery(queries);
            List<Integer> expectedResult = out.lines().mapToInt(Integer::parseInt).boxed().collect(toList());
            assertEquals(expectedResult, actualResult);
        }
    }

}