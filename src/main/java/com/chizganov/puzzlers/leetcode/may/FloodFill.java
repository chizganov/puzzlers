package com.chizganov.puzzlers.leetcode.may;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/">Flood Fill problem</a>
 *
 * @author Ev Chizganov
 */
class FloodFill {

    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int height = image.length;
        int width = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == newColor) return image;

        Queue<Coordinate> coordinatesQueue = new ArrayDeque<>();
        coordinatesQueue.add(new Coordinate(sr, sc));
        while (!coordinatesQueue.isEmpty()) {
            Coordinate coordinate = coordinatesQueue.remove();
            int row = coordinate.row;
            int col = coordinate.col;
            image[row][col] = newColor;
            if (row - 1 >= 0 && image[row - 1][col] == oldColor) coordinatesQueue.add(new Coordinate(row - 1, col));
            if (row + 1 < height && image[row + 1][col] == oldColor) coordinatesQueue.add(new Coordinate(row + 1, col));
            if (col - 1 >= 0 && image[row][col - 1] == oldColor) coordinatesQueue.add(new Coordinate(row, col - 1));
            if (col + 1 < width && image[row][col + 1] == oldColor) coordinatesQueue.add(new Coordinate(row, col + 1));
        }

        return image;
    }

    private static final class Coordinate {

        private final int row;
        private final int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
