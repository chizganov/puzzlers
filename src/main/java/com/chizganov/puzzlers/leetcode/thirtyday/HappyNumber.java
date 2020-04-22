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
            n = digitSquareSum(n);
        }

        return n == 1;
    }

    private static int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    static class FloydSolution extends HappyNumber {

        @Override boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = digitSquareSum(slow);
                fast = digitSquareSum(fast);
                fast = digitSquareSum(fast);
            } while (slow != fast);

            return slow == 1;
        }


    }

}
