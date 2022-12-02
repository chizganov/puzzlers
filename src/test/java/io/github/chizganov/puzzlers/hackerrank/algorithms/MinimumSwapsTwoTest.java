package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSwapsTwoTest {

    @ParameterizedTest
    @TestSource(MinimumSwapsTwo.class)
    void minimumSwaps(MinimumSwapsTwo solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int actualResult = solution.minimumSwaps(arr);
            int expectedResult = exp.nextInt();
            assertEquals(expectedResult, actualResult);
        }
    }

}