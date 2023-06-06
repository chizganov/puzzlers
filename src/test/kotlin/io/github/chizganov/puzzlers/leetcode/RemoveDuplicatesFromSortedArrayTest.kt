package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.collections.shouldStartWith
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class RemoveDuplicatesFromSortedArrayTest {

    @ParameterizedTest
    @TestSource(RemoveDuplicatesFromSortedArray::class)
    fun removeDuplicates(removeDuplicatesFromSortedArray: RemoveDuplicatesFromSortedArray, input: Path, output: Path) {
        val nums = input.readLines().single().split(",").map(String::toInt).toIntArray()
        val expectedUniqueSubarray = output.readLines().single().split(",").map(String::toInt)

        val uniqueSubarraySize = removeDuplicatesFromSortedArray.removeDuplicates(nums)

        assertSoftly {
            nums.toList() shouldStartWith expectedUniqueSubarray
            uniqueSubarraySize shouldBeEqual expectedUniqueSubarray.size
        }
    }
}