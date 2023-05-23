package io.github.chizganov.puzzlers.leetcode

interface FirstOccurrenceInString {
    fun findFirstIndex(haystack: String, needle: String): Int
}

class BuiltInFirstOccurrenceInString : FirstOccurrenceInString {
    override fun findFirstIndex(haystack: String, needle: String) = haystack.indexOf(needle)
}

class DumbOccurrenceInString : FirstOccurrenceInString {
    override fun findFirstIndex(haystack: String, needle: String): Int {
        for (index in 0..haystack.length - needle.length) {
            checkNeedle@ for (iterIndex in needle.indices) {
                when {
                    needle[iterIndex] != haystack[index + iterIndex] -> break@checkNeedle
                    iterIndex == needle.lastIndex -> return index
                }
            }
        }

        return -1
    }
}