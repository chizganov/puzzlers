package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {

    private static final String PATH = RansomNote.class.getName().replace('.', '/') + "/";
    private static RansomNote s = new RansomNote();

    static Stream<Arguments> provideImplementations() {
        return Stream.of(
                Arguments.of(new RansomNote()),
                Arguments.of(new RansomNote.ListSolution())
        );
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void test00(RansomNote impl) {
        s = impl;
        test("input00.txt", "output00.txt");
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void test20(RansomNote impl) {
        s = impl;
        test("input20.txt", "output20.txt");
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void test21(RansomNote impl) {
        s = impl;
        test("input21.txt", "output21.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            in.nextLine();

            String[] magazine = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] note = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            boolean result = s.checkMagazine(magazine, note);
            boolean expResult = exp.nextLine().equals("Yes");
            assertEquals(expResult, result);
        }
    }

}