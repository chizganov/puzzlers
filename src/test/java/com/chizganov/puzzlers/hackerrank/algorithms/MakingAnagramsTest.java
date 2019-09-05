package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class MakingAnagramsTest {

    private static final String PATH = MakingAnagrams.class.getName().replace('.', '/') + "/";
    private static final MakingAnagrams s = new MakingAnagrams();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test15() {
        test("input15.txt", "output15.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String a = in.nextLine();

            String b = in.nextLine();

            int result = s.makeAnagram(a, b);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }

}
