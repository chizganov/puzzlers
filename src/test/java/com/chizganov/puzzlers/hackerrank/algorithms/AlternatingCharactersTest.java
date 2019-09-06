package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class AlternatingCharactersTest {

    private static final String PATH = AlternatingCharacters.class.getName().replace('.', '/') + "/";
    private static final AlternatingCharacters s = new AlternatingCharacters();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test13() {
        test("input13.txt", "output13.txt");
    }

    @Test
    void test14() {
        test("input14.txt", "output14.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            int q = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = new int[q];
            int[] expResult = new int[q];
            for (int qItr = 0; qItr < q; qItr++) {
                String l = in.nextLine();

                result[qItr] = s.alternatingCharacters(l);
                expResult[qItr] = Integer.parseInt(exp.nextLine());
            }

            Assertions.assertArrayEquals(expResult, result);
        }
    }

}
