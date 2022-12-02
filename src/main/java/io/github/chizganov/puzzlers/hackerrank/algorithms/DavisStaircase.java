package io.github.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Math.max;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem">Recursion: Davis' Staircase challenge</a>
 *
 * @author Ev Chizganov
 */
class DavisStaircase {

    int stepPerms(int n) {
        int[] result = new int[max(3, n)];
        result[0] = 1;
        result[1] = 2;
        result[2] = 4;

        for (int i = 3; i < n; i++) result[i] = result[i - 1] + result[i - 2] + result[i - 3];

        return result[n - 1];
    }

}
