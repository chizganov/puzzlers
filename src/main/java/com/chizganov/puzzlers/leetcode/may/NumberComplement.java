package com.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/">Number Complement problem</a>
 *
 * @author Ev Chizganov
 */
class NumberComplement {

    int findComplement(int num) {
        int mask = 1;

        int highBitCount = 1;
        for (int t = mask << 1, step = 1; t != 0x8000_0000; t <<= 1, step++) {
            if ((num & t) != 0) highBitCount = step;
        }
        while (highBitCount-- > 1) mask = (mask << 1) | 1;

        return ~num & mask;
    }

}
