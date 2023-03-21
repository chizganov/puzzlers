package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/fizz-buzz/
* */
class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> = (1..n).map {
        when {
            it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
            it % 3 == 0 -> "Fizz"
            it % 5 == 0 -> "Buzz"
            else -> it.toString()
        }
    }
}