package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/minimum-swaps-2/problem">Minimum Swaps 2 challenge</a>
 *
 * @author Ev Chizganov
 */
class MinimumSwapsTwo {

    int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] - 1 != i) {
                int t = arr[i];
                arr[i] = arr[t - 1];
                arr[t - 1] = t;
                swaps++;
            }
            if (arr[i] - 1 == i) i++;
        }

        return swaps;
    }

}
