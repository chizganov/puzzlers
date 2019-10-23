package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonDivisibleSubsetTest {

    @ParameterizedTest
    @TestSource(NonDivisibleSubset.class)
    void nonDivisibleSubset(NonDivisibleSubset solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String[] nk = in.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            int[] S = new int[n];

            String[] SItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int SItem = Integer.parseInt(SItems[i]);
                S[i] = SItem;
            }

            int result = solution.nonDivisibleSubset(k, S);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}
