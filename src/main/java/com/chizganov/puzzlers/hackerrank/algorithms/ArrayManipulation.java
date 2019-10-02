package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/crush/problem">Array Manipulation challenge</a>
 *
 * @author Ev Chizganov
 */
class ArrayManipulation {

    long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int[] q : queries) {
            int a = q[0] - 1;
            int b = q[1] - 1;
            int k = q[2];

            arr[a] += k;
            if (b + 1 < n) arr[b + 1] += -k;
        }

        long max = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

}
