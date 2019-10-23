package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TheBombermanGameTest {

    @ParameterizedTest
    @TestSource(TheBombermanGame.class)
    void bomberMan(TheBombermanGame solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String[] rcn = in.nextLine().split(" ");

            int r = Integer.parseInt(rcn[0]);
            int n = Integer.parseInt(rcn[2]);

            String[] grid = new String[r];

            for (int i = 0; i < r; i++) {
                String gridItem = in.nextLine();
                grid[i] = gridItem;
            }

            String[] result = solution.bomberMan(n, grid);
            String[] expResult = new String[r];
            for (int i = 0; i < expResult.length; i++) {
                expResult[i] = exp.nextLine();
            }
            assertArrayEquals(expResult, result);
        }
    }

}
