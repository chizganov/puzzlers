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

class BubbleSortTest {

    private static final String SWAPS_COUNT = "Array is sorted in %d swaps.";
    private static final String FIRST_ELEMENT = "First Element: %d";
    private static final String LAST_ELEMENT = "Last Element: %d";

    @ParameterizedTest
    @TestSource(BubbleSort.class)
    void countSwaps(BubbleSort solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solution.countSwaps(a);
            String result = String.format(
                    String.join("\n", SWAPS_COUNT, FIRST_ELEMENT, LAST_ELEMENT),
                    solution.getNumSwaps(),
                    a[0],
                    a[a.length - 1]);
            String expResult = String.join("\n", exp.nextLine(), exp.nextLine(), exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}