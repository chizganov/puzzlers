package com.chizganov.puzzlers.leetcode.may;

import static java.lang.Integer.min;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/">ValidPerfectSquare challenge</a>
 *
 * @author Ev Chizganov
 */
class ValidPerfectSquare {

    private static final int MAX_SQUARE = 46340;

    boolean isPerfectSquare(int num) {
        int left = 1;
        int right = min(num, MAX_SQUARE) + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            long square = (long) mid * mid;

            if (square == num) return true;
            else if (square < num) left = mid + 1;
            else right = mid;
        }

        return false;
    }

}
