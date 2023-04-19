package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/valid-palindrome/
* */
class ValidPalindromeSentence {
    fun isPalindrome(s: String): Boolean {
        val cleansedString =
            s.map { if (it.isLetter() || it.isDigit()) it.toString().lowercase() else "" }.joinToString("")
        var isPalindrome = true
        var startIter = 0
        var endIter = cleansedString.lastIndex

        while (startIter < endIter && isPalindrome) {
            if (cleansedString[startIter] != cleansedString[endIter]) {
                isPalindrome = false
            }
            startIter++
            endIter--
        }

        return isPalindrome
    }
}