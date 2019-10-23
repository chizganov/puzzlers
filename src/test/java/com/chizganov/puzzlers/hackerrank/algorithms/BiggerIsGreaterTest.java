package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BiggerIsGreaterTest {

    @ParameterizedTest
    @TestSource(BiggerIsGreater.class)
    void biggerIsGreater(BiggerIsGreater solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int T = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int TItr = 0; TItr < T; TItr++) {
                String w = in.nextLine();

                String result = solution.biggerIsGreater(w);
                String expResult = exp.nextLine();
                assertEquals(expResult, result);
            }
        }
    }

}
