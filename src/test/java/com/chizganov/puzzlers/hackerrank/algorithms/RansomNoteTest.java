package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {

    // TODO multiply solutions in @TestSource (provide RansomNote.ListSolution)
    @ParameterizedTest
    @TestSource(RansomNote.class)
    void checkMagazine(RansomNote solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            in.nextLine();

            String[] magazine = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] note = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            boolean result = solution.checkMagazine(magazine, note);
            boolean expResult = exp.nextLine().equals("Yes");
            assertEquals(expResult, result);
        }
    }

}