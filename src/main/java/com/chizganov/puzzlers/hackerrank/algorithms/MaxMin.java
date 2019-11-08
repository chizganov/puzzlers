package com.chizganov.puzzlers.hackerrank.algorithms;

import static java.util.Arrays.sort;

/**
 * <a href="https://www.hackerrank.com/challenges/angry-children/problem">Max Min challenge</a>
 *
 * @author Ev Chizganov
 */
class MaxMin {

    int maxMin(int k, int[] arr) {
        sort(arr);

        int minDif = arr[k - 1] - arr[0];
        for (int i = k; i < arr.length; i++) {
            int dif = arr[i] - arr[i - k + 1];
            if (minDif > dif) minDif = dif;
        }

        return minDif;
    }

}
