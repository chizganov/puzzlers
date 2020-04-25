package com.chizganov.puzzlers.leetcode.thirtyday;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/">Jump Game challenge</a>
 *
 * @author Ev Chizganov
 */
class JumpGame {

    boolean canJump(int[] nums) {
        int minJumps = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            minJumps++;
            if (nums[i] >= minJumps) minJumps = 0;
        }

        return minJumps == 0;
    }

}
