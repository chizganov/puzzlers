package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SherlockAndTheValidStringTest {

    private static final SherlockAndTheValidString s = new SherlockAndTheValidString();

    @ParameterizedTest
    @TestSource(SherlockAndTheValidString.class)
    void isValid(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String sin = in.nextLine();

            String result = s.isValid(sin);
            String expResult = exp.nextLine();
            assertEquals(expResult, result);
        }
    }

}
