package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QueueTwoStacksTest {

    @ParameterizedTest
    @TestSource(QueueTwoStacks.class)
    void testQueue(QueueTwoStacks<Integer> solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            in.readLine();

            List<String[]> queries = in.lines().map(s -> s.split(" ")).toList();

            List<String> resultList = new ArrayList<>();
            for (String[] query : queries) {
                switch (parseInt(query[0])) {
                    case 1 -> solution.enqueue(parseInt(query[1]));
                    case 2 -> solution.dequeue();
                    case 3 -> {
                        Integer e = solution.peek();
                        resultList.add(e.toString());
                    }
                }
            }

            String[] expectedResult = out.lines().toArray(String[]::new);
            String[] actualResult = resultList.toArray(new String[0]);
            assertArrayEquals(expectedResult, actualResult);
        }
    }

}