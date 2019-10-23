package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumbersTest {

    @ParameterizedTest
    @TestSource(FibonacciNumbers.class)
    void fibonacci(FibonacciNumbers solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {

            int n = in.nextInt();

            int actualResult = solution.fibonacci(n);
            int expectedResult = out.nextInt();
            assertEquals(expectedResult, actualResult);
        }
    }

}