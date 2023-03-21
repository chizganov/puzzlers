package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/reverse-string/
* */
class ReverseString {

    fun reverseStringInPlace(s: CharArray) {
        for (delay in 0..s.lastIndex / 2) {
            val swap = s[delay]
            s[delay] = s[s.lastIndex - delay]
            s[s.lastIndex - delay] = swap
        }
    }
}