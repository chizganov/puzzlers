package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SherlockAndTheValidStringTest {

    @ParameterizedTest
    @TestSource(SherlockAndTheValidString.class)
    void isValid(SherlockAndTheValidString solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String sin = in.nextLine();

            String result = solution.isValid(sin);
            String expResult = exp.nextLine();
            assertEquals(expResult, result);
        }
    }

}
