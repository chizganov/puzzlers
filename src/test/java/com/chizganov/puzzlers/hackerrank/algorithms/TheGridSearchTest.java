package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TheGridSearchTest {

    @ParameterizedTest
    @TestSource(TheGridSearch.class)
    void gridSearch(TheGridSearch solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int t = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String[] RC = in.nextLine().split(" ");

                int R = Integer.parseInt(RC[0]);
                String[] G = new String[R];
                for (int i = 0; i < R; i++) {
                    String GItem = in.nextLine();
                    G[i] = GItem;
                }

                String[] rc = in.nextLine().split(" ");
                int r = Integer.parseInt(rc[0]);
                String[] P = new String[r];

                for (int i = 0; i < r; i++) {
                    String PItem = in.nextLine();
                    P[i] = PItem;
                }

                String result = solution.gridSearch(G, P);
                String expResult = exp.nextLine();
                assertEquals(expResult, result);
            }
        }
    }

}
