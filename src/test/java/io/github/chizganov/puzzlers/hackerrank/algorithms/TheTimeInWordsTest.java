package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TheTimeInWordsTest {

    @ParameterizedTest
    @TestSource(TheTimeInWords.class)
    void timeInWords(TheTimeInWords solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int h = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int m = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = solution.timeInWords(h, m);
            String expectedResult = exp.nextLine();
            assertEquals(expectedResult, result);
        }
    }

}
