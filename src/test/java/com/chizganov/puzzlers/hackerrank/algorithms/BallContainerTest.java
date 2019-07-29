package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallContainerTest {

    private static final String PATH = BallContainer.class.getName().replace('.', '/') + "/";
    private final BallContainer c = new BallContainer();

    @Test void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test void test06() {
        test("input06.txt", "output06.txt");
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

            for (int qItr = 0; qItr < q; qItr++) {
                int n = in.nextInt();
                in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[][] container = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] containerRowItems = in.nextLine().split(" ");
                    in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < n; j++) {
                        int containerItem = Integer.parseInt(containerRowItems[j]);
                        container[i][j] = containerItem;
                    }
                }

                String result = c.organizingContainers(container);
                String expectedResult = exp.nextLine();
                assertEquals(expectedResult, result);
            }
        }
    }

}
