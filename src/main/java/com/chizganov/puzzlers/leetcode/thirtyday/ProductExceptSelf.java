package com.chizganov.puzzlers.leetcode.thirtyday;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/">Product of Array Except Self challenge</a>
 *
 * @author Ev Chizganov
 */
class ProductExceptSelf {

    int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        result[length - 1] = 1;
        for (int i = length - 1; i > 0; i--) result[i - 1] = nums[i] * result[i];

        int currentMultiplier = 1;
        for (int i = 0; i < length - 1; i++) {
            result[i] = currentMultiplier * result[i];
            currentMultiplier *= nums[i];
        }
        result[length - 1] = currentMultiplier;

        return result;
    }

}
