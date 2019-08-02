package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class QueenAttackTest {

    private static final String PATH = QueenAttack.class.getName().replace('.', '/') + "/";
    private static final QueenAttack c = new QueenAttack();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test void test21() {
        test("input21.txt", "output21.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] nk = in.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String[] r_qC_q = in.nextLine().split(" ");

            int r_q = Integer.parseInt(r_qC_q[0]);

            int c_q = Integer.parseInt(r_qC_q[1]);

            int[][] obstacles = new int[k][2];

            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = in.nextLine().split(" ");
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem;
                }
            }

            int result = c.queensAttack(n, k, r_q, c_q, obstacles);
            int expResult = Integer.parseInt(exp.nextLine());
            Assertions.assertEquals(expResult, result);
        }
    }
}
