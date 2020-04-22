package com.chizganov.puzzlers.leetcode.thirtyday;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/">Number Of Island challenge</a>
 *
 * @author Ev Chizganov
 */
class NumberOfIslands {

    int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;

        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        int islandCount = 0;

        // Used in bfs island traverse
        Queue<Point> visitQueue = new ArrayDeque<>();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (isLand(grid[i][j]) && !visited[i][j]) {
                    islandCount++;
                    // Traverse island using bfs
                    visitQueue.add(new Point(j, i));
                    while (!visitQueue.isEmpty()) {
                        Point point = visitQueue.remove();
                        int x = point.getX();
                        int y = point.getY();

                        visited[y][x] = true;
                        // Check neighbor points
                        if (x > 0 && isLand(grid[y][x - 1]) && !visited[y][x - 1])
                            visitQueue.add(new Point(x - 1, y));
                        if (y > 0 && isLand(grid[y - 1][x]) && !visited[y - 1][x])
                            visitQueue.add(new Point(x, y - 1));
                        if (x < WIDTH - 1 && isLand(grid[y][x + 1]) && !visited[y][x + 1])
                            visitQueue.add(new Point(x + 1, y));
                        if (y < HEIGHT - 1 && isLand(grid[y + 1][x]) && !visited[y + 1][x])
                            visitQueue.add(new Point(x, y + 1));
                    }
                }
            }
        }

        return islandCount;
    }

    private static boolean isLand(char c) {
        return c == '1';
    }

    static class Point {

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private final int x;
        private final int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class RecursiveSolution extends NumberOfIslands {

        @Override int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

            int islandCount = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        islandCount++;
                        traverseIsland(grid, i, j);
                    }
                }
            }

            return islandCount;
        }

        private static void traverseIsland(char[][] grid, int y, int x) {
            if (y < 0 || y >= grid.length || x < 0 || x >= grid[y].length || grid[y][x] != '1') return;

            grid[y][x] = 'x';

            traverseIsland(grid, y - 1, x);
            traverseIsland(grid, y + 1, x);
            traverseIsland(grid, y, x - 1);
            traverseIsland(grid, y, x + 1);
        }

    }

}
