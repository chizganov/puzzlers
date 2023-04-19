package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/top-k-frequent-elements
* */
class TopKFrequentElements {

    fun findTopKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .toIntArray()
    }

}