package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class SherlockAndTheValidStringTest {

    private static final String PATH = SherlockAndTheValidString.class.getName().replace('.', '/') + "/";
    private static final SherlockAndTheValidString s = new SherlockAndTheValidString();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test06() {
        test("input06.txt", "output06.txt");
    }

    @Test
    void test13() {
        test("input13.txt", "output13.txt");
    }

    @Test
    void test18() {
        test("input18.txt", "output18.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String sin = in.nextLine();

            String result = s.isValid(sin);
            String expResult = exp.nextLine();
            Assertions.assertEquals(expResult, result);
        }
    }

}
