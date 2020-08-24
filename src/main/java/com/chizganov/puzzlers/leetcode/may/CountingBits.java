package com.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/">Counting Bits challenge</a>
 *
 * @author Ev Chizganov
 */
class CountingBits {

    int[] countBits(int num) {
        int[] bitsCounts = new int[num + 1];
        if (bitsCounts.length >= 2) bitsCounts[1] = 1;
        if (bitsCounts.length >= 3) bitsCounts[2] = 1;
        if (bitsCounts.length >= 4) bitsCounts[3] = 2;

        int startIndex = 4;
        int rangeLength = 2;
        int subrangeLength = 2;
        for (int i = 4; i < bitsCounts.length; i++) {
            if (i - rangeLength == startIndex) {
                subrangeLength /= 2;
                rangeLength += subrangeLength;
            }
            if (subrangeLength == 0) {
                rangeLength++;
                subrangeLength = rangeLength;
                bitsCounts[i] = bitsCounts[i - 1] + 1;
                startIndex = i + 1;
            } else {
                bitsCounts[i] = bitsCounts[i - rangeLength];
            }
        }

        return bitsCounts;
    }

}
