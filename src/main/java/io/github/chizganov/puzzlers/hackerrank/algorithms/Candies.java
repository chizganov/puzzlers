package io.github.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Math.max;

/**
 * <a href="https://www.hackerrank.com/challenges/candies/problem">Candies challenge</a>
 *
 * @author Ev Chizganov
 */
class Candies {

    long candies(int[] arr) {
        int n = arr.length;
        long[] candies = new long[n];

        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) candies[i] = candies[i - 1] + 1;
            else candies[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) candies[i] = max(candies[i], candies[i + 1] + 1);
        }

        long result = 0;
        for (long c : candies) result += c;

        return result;
    }

}
