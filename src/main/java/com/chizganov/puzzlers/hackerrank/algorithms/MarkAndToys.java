package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/mark-and-toys/problem">Mark And Toys challenge</a>
 *
 * @author Ev Chizganov
 */
class MarkAndToys {

    int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int toysCount = 0;
        int toysPrice = 0;
        while (toysPrice <= k) toysPrice += prices[toysCount++];

        return --toysCount;
    }

}
