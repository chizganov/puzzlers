package io.github.chizganov.puzzlers.leetcode

/**
 * LeetCode 1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * */
class AdjacentDuplicates {
    fun removeDuplicates(s: String): String {
        val sb = StringBuilder()
        for (ch in s) {
            if (sb.isNotEmpty() && sb.last() == ch) {
                sb.deleteCharAt(sb.lastIndex)
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }
}