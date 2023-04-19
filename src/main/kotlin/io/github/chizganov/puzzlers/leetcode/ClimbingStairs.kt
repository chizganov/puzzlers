package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/climbing-stairs/
* */
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        // need only last 2
        when (n) {
            1 -> return 1
            2 -> return 2
        }
        val stepsRequired = intArrayOf(1, 2)
        for (i in 3..n) {
            val steps = stepsRequired[0] + stepsRequired[1]
            stepsRequired[0] = stepsRequired[1]
            stepsRequired[1] = steps
        }
        return stepsRequired[1]
    }
}