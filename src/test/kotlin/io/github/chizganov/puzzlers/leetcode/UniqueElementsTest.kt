package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class UniqueElementsTest {

    @ParameterizedTest
    @TestSource(UniqueElements::class)
    fun sumOfUnique(uniqueElements: UniqueElements, input: Path, output: Path) {
        val nums = input.readLines().single().split(',').map(String::toInt).toIntArray()
        val expectedUniqueElementsSum = output.readLines().single().toInt()
        assertEquals(expectedUniqueElementsSum, uniqueElements.sumOfUnique(nums))
    }
}