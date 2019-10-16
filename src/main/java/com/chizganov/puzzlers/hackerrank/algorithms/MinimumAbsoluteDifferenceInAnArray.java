package com.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

/**
 * <a href="https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem">Minimum Absolute Difference in an Array challenge</a>
 *
 * @author Ev Chizganov
 */
class MinimumAbsoluteDifferenceInAnArray {

    int minimumAbsoluteDifference(int[] arr) {
        int minDif = Integer.MAX_VALUE;

        sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int dif = abs(arr[i + 1] - arr[i]);
            if (dif < minDif) minDif = dif;
        }

        return minDif;
    }

}
