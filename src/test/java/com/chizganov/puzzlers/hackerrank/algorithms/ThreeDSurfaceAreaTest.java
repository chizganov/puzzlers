package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeDSurfaceAreaTest {

    @ParameterizedTest
    @TestSource(ThreeDSurfaceArea.class)
    void surfaceArea(ThreeDSurfaceArea solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String[] HW = in.nextLine().split(" ");

            int H = Integer.parseInt(HW[0]);
            int W = Integer.parseInt(HW[1]);

            int[][] A = new int[H][W];

            for (int i = 0; i < H; i++) {
                String[] ARowItems = in.nextLine().split(" ");
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < W; j++) {
                    int AItem = Integer.parseInt(ARowItems[j]);
                    A[i][j] = AItem;
                }
            }

            int result = solution.surfaceArea(A);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}
