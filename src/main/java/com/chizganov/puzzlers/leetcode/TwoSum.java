package com.chizganov.puzzlers.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum challenge</a>
 *
 * @author Ev Chizganov
 */
class TwoSum {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (numToIndex.containsKey(dif)) return new int[]{numToIndex.get(dif), i};
            else numToIndex.put(nums[i], i);
        }

        return new int[0];
    }

}
