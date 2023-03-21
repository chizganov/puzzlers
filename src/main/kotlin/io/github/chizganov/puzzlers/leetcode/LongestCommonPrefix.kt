package io.github.chizganov.puzzlers.leetcode

/*
* https://leetcode.com/problems/longest-common-prefix/
* */
class LongestCommonPrefix {

    fun findLongestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs.first()
        if (strs.any { it.isEmpty() }) return ""

        val prefix = mutableListOf<Char>()
        val (str1, str2) = strs
        (0..Integer.min(str1.lastIndex, str2.lastIndex))
            .takeWhile { str1[it] == str2[it] }
            .forEach { prefix.add(str1[it]) }

        strs.drop(2).forEach { str ->
            val removeCount = (0..Integer.min(prefix.lastIndex, str.lastIndex))
                .takeWhile { prefix[it] == str[it] }
                .lastOrNull()
                ?.let { lastCommonCharIndex -> prefix.size - lastCommonCharIndex - 1 }
                ?: prefix.size
            repeat(removeCount) {
                prefix.removeLast()
            }
        }

        return prefix.joinToString("")
    }

}