package com.chizganov.puzzlers.leetcode.thirtyday;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/">Single Number challenge</a>
 *
 * @author Ev Chizganov
 */
class SingleNumber {

    int singleNumber(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int n : nums) {
            if (numToCount.containsKey(n)) numToCount.remove(n);
            else numToCount.put(n, 1);
        }

        return numToCount.keySet().iterator().next();
    }

    static class EffectiveSolution extends SingleNumber {

        @Override int singleNumber(int[] nums) {
            int result = 0;
            for (int i : nums) {
                result ^= i;
            }

            return result;
        }
    }

}
