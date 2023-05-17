package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/intersection-of-two-arrays-ii/
* */
class TwoArrayIntersectionII {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val numToCount = mutableMapOf<Int, Int>() // nums1.groupingBy { it }.eachCount()
        val intersection = mutableListOf<Int>()

        for (num in nums1) {
            numToCount[num] = numToCount.getOrDefault(num, 0) + 1
        }

        for (num in nums2) {
            if (numToCount.containsKey(num) && numToCount.getOrDefault(num, 0) > 0) {
                intersection.add(num)
                numToCount[num] = numToCount.getOrDefault(num, 0) - 1
            }
        }

        return intersection.toIntArray()
    }
}