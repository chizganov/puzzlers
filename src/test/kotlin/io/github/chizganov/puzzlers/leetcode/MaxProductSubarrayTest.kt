package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class MaxProductSubarrayTest {

    @ParameterizedTest
    @TestSource(value = MaxProductSubarray::class, implementations = [EffectiveDpMaxProductSubarray::class])
    fun maxProduct(maxProductSubarray: MaxProductSubarray, input: Path, output: Path) {
        val nums = input.readLines().single().split(",").map(String::toInt).toIntArray()
        val expectedMaxProductSubarray = output.readLines().single().toInt()

        assertEquals(expectedMaxProductSubarray, maxProductSubarray.maxProduct(nums))
    }
}