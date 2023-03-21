package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class LongestCommonPrefixTest {

    @ParameterizedTest
    @TestSource(LongestCommonPrefix::class)
    fun findLongestCommonPrefix(longestCommonPrefix: LongestCommonPrefix, input: Path, output: Path) {
        val strings = input.readLines().first().split(",").toTypedArray()
        val expectedPrefix = output.readLines().firstOrNull() ?: ""

        assertEquals(expectedPrefix, longestCommonPrefix.findLongestCommonPrefix(strings))
    }
}