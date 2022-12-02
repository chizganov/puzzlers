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

class MarkAndToysTest {

    @ParameterizedTest
    @TestSource(MarkAndToys.class)
    void maximumToys(MarkAndToys solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String[] nk = in.nextLine().split(" ");

            int k = Integer.parseInt(nk[1]);
            int[] prices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int result = solution.maximumToys(prices, k);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}