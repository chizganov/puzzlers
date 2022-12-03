package io.github.chizganov.puzzlers.leetcode

import kotlin.math.min

/**
 * LeetCode 697. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/
 * Runtime: 268 ms, faster than 100.00% of Kotlin online submissions for Degree of an Array.
 * Memory Usage: 42.5 MB, less than 100.00% of Kotlin online submissions for Degree of an Array.
 * */
class ArrayDegree {
    fun findShortestSubArray(nums: IntArray): Int {
        val numToOccurrencesInfo = mutableMapOf<Int, OccurrenceInfo>()
        var degree = 0
        var minLength = nums.size
        for (i in nums.indices) {
            val num = nums[i]
            val occurrence = numToOccurrencesInfo[num] ?: OccurrenceInfo(0, i, i)
            occurrence.count++
            occurrence.rightmost = i
            if (occurrence.count == 1) {
                numToOccurrencesInfo[num] = occurrence
            }
            if (occurrence.count > degree) {
                degree = occurrence.count
                minLength = occurrence.rightmost - occurrence.leftmost + 1
            } else if (occurrence.count == degree) {
                minLength = min(minLength, occurrence.rightmost - occurrence.leftmost + 1)
            }
        }
        return minLength
    }
}

data class OccurrenceInfo(var count: Int, var leftmost: Int, var rightmost: Int)