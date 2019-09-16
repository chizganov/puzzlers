package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/new-year-chaos/problem">New Year Chaos challenge</a>
 *
 * @author Ev Chizganov
 */
class NewYearChaos {

    int minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) return -1;
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) bribes++;
        }

        return bribes;
    }

}
