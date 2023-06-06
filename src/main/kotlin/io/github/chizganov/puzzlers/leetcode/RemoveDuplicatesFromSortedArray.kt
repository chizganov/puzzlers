package io.github.chizganov.puzzlers.leetcode

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var duplicates = 0
        for (i in 1..nums.lastIndex) {
            if (nums[i - duplicates - 1] == nums[i]) {
                duplicates++
            } else {
                nums[i - duplicates] = nums[i]
            }
        }

        return nums.size - duplicates
    }
}