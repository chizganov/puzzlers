package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedStringTest {

    @ParameterizedTest
    @TestSource(RepeatedString.class)
    void repeatedString(RepeatedString solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String s = in.nextLine();

            long n = in.nextLong();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = solution.repeatedString(s, n);
            long expResult = Long.parseLong(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}
