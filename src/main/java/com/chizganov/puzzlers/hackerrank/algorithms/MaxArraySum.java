package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/max-array-sum/problem">Max Array Sum challenge</a>
 *
 * @author Ev Chizganov
 */
class MaxArraySum {

    int maxSubsetSum(int[] arr) {
        int n = arr.length;
        int[] maxSum = new int[n];

        maxSum[n - 1] = arr[n - 1];
        if (n >= 2) maxSum[n - 2] = Math.max(arr[n - 2], maxSum[n - 1]);

        for (int i = n - 3; i >= 0; i--)
            maxSum[i] = max(arr[i], arr[i] + maxSum[i + 2], maxSum[i + 1]);

        return maxSum[0];
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}
