package io.github.chizganov.puzzlers.leetcode.thirtyday;

import static java.lang.Math.min;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/">Minimum Path Sum challenge</a>
 *
 * @author Ev Chizganov
 */
class MinimumPathSum {

    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;

        for (int i = 1; i < HEIGHT; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < WIDTH; j++) grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < HEIGHT; i++)
            for (int j = 1; j < WIDTH; j++)
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1]);

        return grid[HEIGHT - 1][WIDTH - 1];
    }

}
