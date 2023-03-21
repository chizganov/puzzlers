package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertContentEquals

internal class ReverseStringTest {

    @ParameterizedTest
    @TestSource(ReverseString::class)
    fun testReverseString(reverseString: ReverseString, input: Path, output: Path) {
        val inputArray = input.readLines().first().toCharArray()
        val expectedRevertedArray = output.readLines().first().toCharArray()
        reverseString.reverseStringInPlace(inputArray)

        assertContentEquals(expectedRevertedArray, inputArray)
    }
}