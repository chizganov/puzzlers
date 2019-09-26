package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonChildTest {

    private static final CommonChild s = new CommonChild();

    @ParameterizedTest
    @TestSource(CommonChild.class)
    void commonChild(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String s1 = in.nextLine();
            String s2 = in.nextLine();

            int result = s.commonChild(s1, s2);
            int expectedResult = Integer.parseInt(exp.nextLine());
            assertEquals(expectedResult, result);
        }
    }

}
