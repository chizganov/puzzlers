package io.github.chizganov.puzzlers.leetcode

import kotlin.math.max

interface MaxProductSubarray {
    fun maxProduct(nums: IntArray): Int
}

class EffectiveDpMaxProductSubarray : MaxProductSubarray {
    override fun maxProduct(nums: IntArray): Int {
        var (maxProduct, maxSuffix, minSuffix) = List(3) { nums[0] }

        nums.drop(1).forEach { num ->
            maxProduct = intArrayOf(maxProduct, maxSuffix * num, minSuffix * num, num).max()
            with(Pair(minSuffix, maxSuffix)) {
                maxSuffix = intArrayOf(first * num, second * num, num).max()
                minSuffix = intArrayOf(first * num, second * num, num).min()
            }
        }

        return maxProduct
    }
}

@Suppress("unused")
class BruteForceMaxProductSubarray : MaxProductSubarray {
    override fun maxProduct(nums: IntArray): Int {
        val size = nums.size
        val multiplicationMatrix: Array<IntArray> = Array(size) { IntArray(size) }
        var maxProduct = nums[0]

        for (i in 0..nums.lastIndex) {
            multiplicationMatrix[i][i] = nums[i]
            maxProduct = max(maxProduct, nums[i])
        }

        for (window in 2..size) {
            for (i in 0..size - window) {
                val windowLastOffset = i + window - 1
                val product = multiplicationMatrix[i][windowLastOffset - 1] * nums[windowLastOffset]
                maxProduct = max(maxProduct, product)
                multiplicationMatrix[i][windowLastOffset] = product
            }
        }

        return maxProduct
    }
}