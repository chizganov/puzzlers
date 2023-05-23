package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class FirstOccurrenceInStringTest {

    @ParameterizedTest
    @TestSource(
        value = FirstOccurrenceInString::class,
        implementations = [DumbOccurrenceInString::class, BuiltInFirstOccurrenceInString::class]
    )
    fun findFirstIndex(firstOccurrenceInString: FirstOccurrenceInString, input: Path, output: Path) {
        val (haystack, needle) = input.readLines().zipWithNext().single()
        val expectedFirstOccurrenceIndex = output.readLines().map(String::toInt).single()

        assertEquals(expectedFirstOccurrenceIndex, firstOccurrenceInString.findFirstIndex(haystack, needle))
    }
}