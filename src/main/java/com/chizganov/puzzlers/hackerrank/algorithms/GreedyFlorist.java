package com.chizganov.puzzlers.hackerrank.algorithms;

import static java.util.Arrays.sort;

/**
 * <a href="https://www.hackerrank.com/challenges/greedy-florist/problem">Greedy Florist challenge</a>
 *
 * @author Ev Chizganov
 */
class GreedyFlorist {

    int getMinimumCost(int k, int[] c) {
        int n = c.length;
        int minCost = 0;
        sort(c);

        for (int i = n - 1; i >= 0; i--)
            minCost += c[i] * ((n - i - 1) / k + 1);

        return minCost;
    }

}
