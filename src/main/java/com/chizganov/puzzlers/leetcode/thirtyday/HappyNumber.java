package com.chizganov.puzzlers.leetcode.thirtyday;

import java.util.Set;
import java.util.TreeSet;

import static java.lang.Math.pow;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/">Happy Number challenge</a>
 *
 * @author Ev Chizganov
 */
class HappyNumber {

    boolean isHappy(int n) {
        Set<Integer> visited = new TreeSet<>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            int t = 0;
            while (n != 0) {
                t += pow(n % 10, 2);
                n /= 10;
            }
            n = t;
        }

        return n == 1;
    }

}
