package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/crush/problem">Array Manipulation challenge</a>
 *
 * @author Ev Chizganov
 */
class ArrayManipulation {

    long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        long max = 0;

        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            int k = q[2];

            for (int i = a - 1; i < b; i++) {
                arr[i] += k;
                if (arr[i] > max) max = arr[i];
            }
        }

        return max;
    }

}
