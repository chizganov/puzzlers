package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertContains

internal class LongestPalindromicSubstringTest {

    @ParameterizedTest
    @TestSource(LongestPalindromicSubstring::class)
    fun longestPalindrome(longestPalindromicSubstring: LongestPalindromicSubstring, input: Path, output: Path) {
        val string = input.readLines().first()
        val expectedPalindromicSubstring = output.readLines()
        assertContains(expectedPalindromicSubstring, longestPalindromicSubstring.longestPalindrome(string))
    }
}