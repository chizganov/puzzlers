package io.github.chizganov.puzzlers.leetcode

/**
 * LeetCode 1748. Sum of Unique Elements
 * https://leetcode.com/problems/sum-of-unique-elements/
 * */
class UniqueElements {
    fun sumOfUnique(nums: IntArray) = nums.groupBy { it }.filter { it.value.size == 1 }.keys.sum()
}