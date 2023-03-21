package io.github.chizganov.puzzlers.leetcode

class BitsNumber {

    fun hammingWeight(n: Int): Int = (1..32).map { n ushr it }.sumOf { it and 1 }

    @Suppress("unused")
    fun hammingWeightBuiltIn(n: Int): Int = n.countOneBits()
}