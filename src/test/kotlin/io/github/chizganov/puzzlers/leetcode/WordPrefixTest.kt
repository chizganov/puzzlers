package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class WordPrefixTest {

    @ParameterizedTest
    @TestSource(WordPrefix::class)
    fun reversePrefix(wordPrefix: WordPrefix, input: Path, output: Path) {
        val (word, ch) = input.readLines()
        val expectedReversedResultString = output.readLines().single()
        assertEquals(expectedReversedResultString, wordPrefix.reversePrefix(word, ch.single()))
    }
}