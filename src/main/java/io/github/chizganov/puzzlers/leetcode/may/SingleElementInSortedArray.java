package io.github.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/">SinleElementInSortedArray challenge</a>
 *
 * @author Ev Chizganov
 */
class SingleElementInSortedArray {

    int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int n : nums) result ^= n;

        return result;
    }

}
