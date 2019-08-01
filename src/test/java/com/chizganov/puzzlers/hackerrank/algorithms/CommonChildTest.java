package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonChildTest {

    private static final String PATH = CommonChild.class.getName().replace('.', '/') + "/";
    private static final CommonChild c = new CommonChild();

    @Test void test06() {
        test("input06.txt", "output06.txt");
    }

    @Test void test07() {
        test("input07.txt", "output07.txt");
    }

    @Test void test14() {
        test("input14.txt", "output14.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            int result = c.commonChild(s1, s2);
            int expectedResult = Integer.parseInt(exp.nextLine());
            assertEquals(expectedResult, result);
        }
    }

}
