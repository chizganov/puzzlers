package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class TheGridSearchTest {

    private static final String PATH = TheGridSearch.class.getName().replace('.', '/') + "/";
    private static final TheGridSearch task = new TheGridSearch();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            int t = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String[] RC = in.nextLine().split(" ");

                int R = Integer.parseInt(RC[0]);

                int C = Integer.parseInt(RC[1]);

                String[] G = new String[R];

                for (int i = 0; i < R; i++) {
                    String GItem = in.nextLine();
                    G[i] = GItem;
                }

                String[] rc = in.nextLine().split(" ");

                int r = Integer.parseInt(rc[0]);

                int c = Integer.parseInt(rc[1]);

                String[] P = new String[r];

                for (int i = 0; i < r; i++) {
                    String PItem = in.nextLine();
                    P[i] = PItem;
                }

                String result = task.gridSearch(G, P);
                String expResult = exp.nextLine();
                Assertions.assertEquals(expResult, result);
            }
        }
    }

}
