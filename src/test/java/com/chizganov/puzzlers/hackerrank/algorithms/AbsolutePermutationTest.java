package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsolutePermutationTest {

    @ParameterizedTest
    @TestSource(AbsolutePermutation.class)
    void absolutePermutation(AbsolutePermutation solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int t = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String expLine;
            StringBuilder strBuilder = new StringBuilder();

            for (int tItr = 0; tItr < t; tItr++) {
                expLine = exp.nextLine();
                strBuilder.setLength(0);

                String[] nk = in.nextLine().split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                int[] result = solution.absolutePermutation(n, k);

                for (int i = 0; i < result.length; i++) {
                    strBuilder.append(result[i]);

                    if (i != result.length - 1) {
                        strBuilder.append(" ");
                    }
                }

                assertEquals(expLine, strBuilder.toString());
            }
        }
    }

}
