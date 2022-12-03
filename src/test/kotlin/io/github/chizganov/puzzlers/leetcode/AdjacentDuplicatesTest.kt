package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class AdjacentDuplicatesTest {

    @ParameterizedTest
    @TestSource(AdjacentDuplicates::class)
    fun removeDuplicates(adjacentDuplicates: AdjacentDuplicates, input: Path, output: Path) {
        val s = input.readLines().single()
        val expectedCleanedStr = output.readLines().single()
        assertEquals(expectedCleanedStr, adjacentDuplicates.removeDuplicates(s))
    }
}