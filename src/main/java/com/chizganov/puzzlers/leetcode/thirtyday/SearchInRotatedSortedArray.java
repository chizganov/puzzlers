package com.chizganov.puzzlers.leetcode.thirtyday;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/">Search In Rotated Sorted Array challenge</a>
 *
 * @author Ev Chizganov
 */
class SearchInRotatedSortedArray {

    int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int LENGTH = nums.length;
        int shift = nums[0] > nums[LENGTH - 1] ? findFirstElementIndex(nums, 0, LENGTH - 1) : 0;

        return shiftedBinarySearch(nums, target, shift, 0, LENGTH - 1);
    }

    private static int findFirstElementIndex(int[] nums, int left, int right) {
        int mid = (right + left) / 2;

        if (nums[mid] > nums[mid + 1]) return mid + 1;

        return nums[mid] > nums[0] ? findFirstElementIndex(nums, mid, right) : findFirstElementIndex(nums, left, mid);
    }

    private static int shiftedBinarySearch(int[] nums, int target, int shift, int left, int right) {
        int mid = (left + right) / 2;
        int shiftedMid = (mid + shift) % nums.length;

        if (nums[shiftedMid] == target) return shiftedMid;
        else if (left == right) return -1;

        return nums[shiftedMid] > target ? shiftedBinarySearch(nums, target, shift, left, mid) :
                shiftedBinarySearch(nums, target, shift, mid + 1, right);
    }

}
