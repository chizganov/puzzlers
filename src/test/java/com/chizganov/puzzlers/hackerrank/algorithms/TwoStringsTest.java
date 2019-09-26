package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoStringsTest {

    private static final TwoStrings s = new TwoStrings();

    @ParameterizedTest
    @TestSource(TwoStrings.class)
    void twoStrings(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int q = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String s1 = in.nextLine();
                String s2 = in.nextLine();

                String result = s.twoStrings(s1, s2);
                String expResult = exp.nextLine();
                assertEquals(expResult, result);
            }
        }
    }

}