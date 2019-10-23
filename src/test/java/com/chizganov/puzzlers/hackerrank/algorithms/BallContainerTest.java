package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BallContainerTest {

    @ParameterizedTest
    @TestSource(BallContainer.class)
    void organizingContainers(BallContainer solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int q = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                int n = in.nextInt();
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[][] container = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] containerRowItems = in.nextLine().split(" ");
                    in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < n; j++) {
                        int containerItem = Integer.parseInt(containerRowItems[j]);
                        container[i][j] = containerItem;
                    }
                }

                String result = solution.organizingContainers(container);
                String expectedResult = exp.nextLine();
                assertEquals(expectedResult, result);
            }
        }
    }

}
