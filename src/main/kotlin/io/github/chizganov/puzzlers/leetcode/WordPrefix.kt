package io.github.chizganov.puzzlers.leetcode

/**
 * LeetCode 2000. Reverse Prefix of Word
 * https://leetcode.com/problems/reverse-prefix-of-word/
 * */
open class WordPrefix {
    open fun reversePrefix(word: String, ch: Char): String {
        var i = 0
        val sb = StringBuilder()
        while (i < word.length && word[i] != ch) {
            sb.append(word[i])
            i++
        }
        if (i >= word.length) return word
        sb.append(word[i++])
        sb.reverse()
        while (i < word.length) {
            sb.append(word[i])
            i++
        }
        return sb.toString()
    }
}