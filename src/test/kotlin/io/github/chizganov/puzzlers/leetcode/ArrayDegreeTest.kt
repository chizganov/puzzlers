package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class ArrayDegreeTest {

    @ParameterizedTest
    @TestSource(ArrayDegree::class)
    fun findShortestSubArray(arrayDegree: ArrayDegree, input: Path, output: Path) {
        val nums = input.readLines().single().split(',').map(String::toInt).toIntArray()
        val expectedSmallestSubarrayDegreeSize = output.readLines().single().toInt()
        assertEquals(expectedSmallestSubarrayDegreeSize, arrayDegree.findShortestSubArray(nums))
    }
}