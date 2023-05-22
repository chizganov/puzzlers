package io.github.chizganov.puzzlers.leetcode

import kotlin.math.min

private const val INT_MAX_SQRT = 46340 // to avoid long conversion

interface Sqrt {
    fun findSqrt(x: Int): Int
}

open class DumbSqrt : Sqrt {
    override fun findSqrt(x: Int): Int {
        for (sqrt in 0..x) {
            val sqr = sqrt * sqrt
            when {
                sqr == x -> return sqrt
                sqr > x || sqr < 0 -> return sqrt - 1
            }
        }

        return x
    }
}

open class BinarySearchSqrt : Sqrt {
    override fun findSqrt(x: Int): Int {
        var start = 0
        var end = min(x, INT_MAX_SQRT)

        while (start <= end) {
            val mid = start + (end - start) / 2
            val square = mid * mid

            when {
                square == x -> return mid
                square < x -> start = mid + 1
                else -> end = mid - 1
            }
        }

        return end
    }
}