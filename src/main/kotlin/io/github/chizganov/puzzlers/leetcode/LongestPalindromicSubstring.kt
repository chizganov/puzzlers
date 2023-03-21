package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/longest-palindromic-substring
* */
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        val length = s.length
        val isPalindromicMatrix: Array<BooleanArray> = Array(length) { BooleanArray(length) }
        var maxSubstring = 0 to 0
        for (i in 0 until length) {
            // fill single character palindrome
            isPalindromicMatrix[i][i] = true
            // fill pairs
            if (i < length - 1) {
                isPalindromicMatrix[i][i + 1] = s[i] == s[i + 1]
                if (isPalindromicMatrix[i][i + 1]) {
                    maxSubstring = i to i + 1
                }
            }
        }

        for (distance in 2 until length) {
            for (i in 0 until length - distance) {
                isPalindromicMatrix[i][i + distance] =
                    isPalindromicMatrix[i + 1][i + distance - 1] && s[i] == s[i + distance]
                if (isPalindromicMatrix[i][i + distance]) {
                    maxSubstring = i to i + distance
                }
            }
        }

        return s.substring(maxSubstring.first, maxSubstring.second + 1)
    }
}