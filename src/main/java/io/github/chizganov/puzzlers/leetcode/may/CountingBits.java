package io.github.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/">Counting Bits challenge</a>
 *
 * @author Ev Chizganov
 */
class CountingBits {

    int[] countBits(int num) {
        int[] bitsCounts = new int[num + 1];
        if (bitsCounts.length >= 1) bitsCounts[0] = 0;
        if (bitsCounts.length >= 2) bitsCounts[1] = 1;

        for (int i = 2; i < bitsCounts.length; i++) {
            if (i % 2 == 0) bitsCounts[i] = bitsCounts[i / 2];
            else bitsCounts[i] = bitsCounts[i - 1] + 1;
        }

        return bitsCounts;
    }

}
