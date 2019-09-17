package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    private static final String PATH = RansomNote.class.getName().replace('.', '/') + "/";
    private static final RansomNote s = new RansomNote();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test20() {
        test("input20.txt", "output20.txt");
    }

    @Test
    void test21() {
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