package io.github.chizganov.puzzlers.leetcode

open class ThirdMaxNumber {
    open fun thirdMax(nums: IntArray): Int {
        val max = IntArray(3)
        max[0] = nums[0]
        for (num in nums) {
            if (num > max[0]) {
                max[0] = num
            }
        }
        for (i in 1..2) {
            max[i] = max[i - 1]
            for (num in nums) {
                if (num < max[i - 1] && (max[i - 1] == max[i] || num > max[i])) {
                    max[i] = num
                }
            }
        }
        return if (max[2] == max[1]) max[0] else max[2]
    }
}

class SimpleThirdMaxNumber : ThirdMaxNumber() {
    override fun thirdMax(nums: IntArray) =
        nums.also(IntArray::sortDescending).distinct().getOrNull(2) ?: nums[0]
}