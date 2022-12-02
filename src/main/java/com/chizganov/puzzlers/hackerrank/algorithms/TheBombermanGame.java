package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/bomber-man/problem">The Bomberman Game challenge</a>
 *
 * @author Ev Chizganov
 */
class TheBombermanGame {

    String[] bomberMan(int n, String[] grid) {
        if (n == 1) return grid;
        // Every second the field is full of bombs
        if (n % 2 == 0) {
            String line = "O".repeat(grid[0].length());
            Arrays.fill(grid, line);

            return grid;
        }

        int h = grid.length;
        int w = grid[0].length();
        byte[][] a = new byte[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i].charAt(j) == 'O') a[i][j] = 1;
            }
        }
        /*
         Every fourth second from 3 or 5 the same
         As 3, 7, 11..
         Or 5, 9, 13..
        */
        int t = 3;
        if ((n - 5) % 4 == 0) t = 5;
        for (int i = 3; i <= t; i += 2) {
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (a[r][c] == 0) a[r][c] = 3;
                }
            }

            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (a[r][c] == 1) {
                        a[r][c] = 0;
                        if (r - 1 >= 0) a[r - 1][c] = 0;
                        if (c - 1 >= 0) a[r][c - 1] = 0;
                        if (r + 1 < h && a[r + 1][c] != 1) a[r + 1][c] = 0;
                        if (c + 1 < w && a[r][c + 1] != 1) a[r][c + 1] = 0;
                    } else if (a[r][c] == 3) {
                        a[r][c] = 1;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (a[r][c] == 0) builder.append('.');
                else builder.append('O');
            }
            grid[r] = builder.toString();
            builder.setLength(0);
        }

        return grid;
    }

}
