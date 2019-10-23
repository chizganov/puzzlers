package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MakingAnagramsTest {

    @ParameterizedTest
    @TestSource(MakingAnagrams.class)
    void makeAnagram(MakingAnagrams solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String a = in.nextLine();
            String b = in.nextLine();

            int result = solution.makeAnagram(a, b);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }

}
