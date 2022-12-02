package io.github.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/">Contiguous Array problem</a>
 *
 * @author Ev Chizganov
 */
class ContiguousArray {

    int findMaxLength(int[] nums) {
        if (nums.length < 2) return 0;

        Map<Integer, Integer> countToIndex = new HashMap<>();
        int maxLength = 0;

        countToIndex.put(0, -1);
        for (int i = 0, count = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (countToIndex.containsKey(count)) {
                maxLength = max(maxLength, i - countToIndex.get(count));
            } else {
                countToIndex.put(count, i);
            }
        }

        return maxLength;
    }

}
