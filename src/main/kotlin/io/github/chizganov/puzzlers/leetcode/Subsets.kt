package io.github.chizganov.puzzlers.leetcode

class Subsets {

    // unique elements = a new element and a combination with every subset are unique and should be added without deduplication
    // subsets(a[:n]) = subsets(a[:n-1]) + a[n] + subsets(a[:n-1]) { add a[n] }
    fun findSubsets(nums: IntArray): List<List<Int>> = nums.fold(listOf(emptyList())) { subsets, n ->
        subsets + subsets.map { it + n }
    }
}