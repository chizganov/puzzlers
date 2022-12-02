package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialStringAgainTest {

    @ParameterizedTest
    @TestSource(SpecialStringAgain.class)
    void substrCount(SpecialStringAgain solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {
            in.skip("\\d+(\r\n|[\n\r\u2028\u2029\u0085])?");
            String inputString = in.nextLine();

            Long actualResult = solution.substrCount(inputString.length(), inputString);
            Long expectedResult = out.nextLong();
            assertEquals(expectedResult, actualResult);
        }
    }

}