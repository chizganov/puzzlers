package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AlternatingCharactersTest {

    @ParameterizedTest
    @TestSource(AlternatingCharacters.class)
    void alternatingCharacters(AlternatingCharacters solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int q = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = new int[q];
            int[] expResult = new int[q];

            for (int qItr = 0; qItr < q; qItr++) {
                String l = in.nextLine();

                result[qItr] = solution.alternatingCharacters(l);
                expResult[qItr] = Integer.parseInt(exp.nextLine());
            }

            assertArrayEquals(expResult, result);
        }
    }

}
