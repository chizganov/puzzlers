package com.chizganov.puzzlers.leetcode.may;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/">Maximum Sum Circular Subarray problem</a>
 *
 * @author Ev Chizganov
 */
class MaxSumCircularSubarray {

    int maxSubarraySumCircular(int[] a) {
        int length = a.length;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0, currentMinSum = 0, currentMaxSum = 0; i < length; i++) {
            if (currentMaxSum <= 0) currentMaxSum = 0;
            if (currentMinSum >= 0) currentMinSum = 0;
            currentMaxSum += a[i];
            currentMinSum += a[i];

            maxSum = max(maxSum, currentMaxSum);
            minSum = min(minSum, currentMinSum);
            total += a[i];
        }

        return maxSum <= 0 ? maxSum : max(maxSum, total - minSum);
    }

}
