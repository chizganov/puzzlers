package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertContentEquals

internal class GivenOrderArrayTest {
    @ParameterizedTest
    @TestSource(GivenOrderArray::class)
    fun createTargetArray(givenOrderArray: GivenOrderArray, input: Path, output: Path) {
        val (nums, indices) = input.readLines()
            .map { line -> line.split(',').map { it.toInt() }.toIntArray() }
            .zipWithNext()
            .single()

        val expectedArray = output.readLines()
            .map { line -> line.split(',').map { it.toInt() }.toIntArray() }
            .single()

        assertContentEquals(expectedArray, givenOrderArray.createTargetArray(nums, indices))
    }
}