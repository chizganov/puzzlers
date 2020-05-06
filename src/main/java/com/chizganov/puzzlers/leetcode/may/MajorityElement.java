package com.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/">Majority Element problem</a>
 *
 * @author Ev Chizganov
 */
class MajorityElement {

    int majorityElement(int[] nums) {
        sort(nums);
        return nums[nums.length / 2];
    }

    static final class MapSolution extends MajorityElement {

        @Override int majorityElement(int[] nums) {
            Map<Integer, Integer> numToCount = new HashMap<>();

            for (int n : nums) {
                int count = numToCount.merge(n, 1, Integer::sum);
                if (count > nums.length / 2) return n;
            }

            throw new IllegalArgumentException("No majority element.");
        }
    }

}
