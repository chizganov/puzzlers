package com.chizganov.puzzlers.leetcode.may;

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

}
