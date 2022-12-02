package io.github.chizganov.puzzlers.leetcode

/**
 * <a href="https://leetcode.com/problems/create-target-array-in-the-given-order/">1389. Create Target Array in the Given Order</a>
 * */
class GivenOrderArray {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            val currentIndex = index[i]
            val num = nums[i]
            for (shiftIndex in i downTo currentIndex + 1) {
                result[shiftIndex] = result[shiftIndex - 1]
            }
            result[currentIndex] = num
        }
        return result
    }
}