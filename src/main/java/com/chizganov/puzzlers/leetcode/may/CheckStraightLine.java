package com.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/">Check If It Is a Straight Line problem</a>
 *
 * @author Ev Chizganov
 */
class CheckStraightLine {

    private static final int X = 0;
    private static final int Y = 1;

    boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][X] - coordinates[0][X];
        int dy = coordinates[1][Y] - coordinates[0][Y];

        for (int[] point : coordinates)
            if (dx * (point[Y] - coordinates[1][Y]) != dy * (point[X] - coordinates[1][X])) return false;

        return true;
    }

}
