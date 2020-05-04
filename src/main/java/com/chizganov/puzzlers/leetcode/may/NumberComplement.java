package com.chizganov.puzzlers.leetcode.may;

import static java.lang.Integer.highestOneBit;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/">Number Complement problem</a>
 *
 * @author Ev Chizganov
 */
class NumberComplement {

    int findComplement(int num) {
        return ~num + (highestOneBit(num) << 1);
    }

}
