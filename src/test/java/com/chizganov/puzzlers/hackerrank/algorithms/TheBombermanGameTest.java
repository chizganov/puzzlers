package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TheBombermanGameTest {

    private static final String PATH = TheBombermanGame.class.getName().replace('.', '/') + "/";
    private static final TheBombermanGame game = new TheBombermanGame();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test25() {
        test("input25.txt", "output25.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] rcn = in.nextLine().split(" ");

            int r = Integer.parseInt(rcn[0]);

            int c = Integer.parseInt(rcn[1]);

            int n = Integer.parseInt(rcn[2]);

            String[] grid = new String[r];

            for (int i = 0; i < r; i++) {
                String gridItem = in.nextLine();
                grid[i] = gridItem;
            }

            String[] result = game.bomberMan(n, grid);
            String[] expResult = new String[r];
            for(int i = 0; i < expResult.length; i++) {
                expResult[i] = exp.nextLine();
            }
            assertArrayEquals(expResult, result);
        }
    }

}
