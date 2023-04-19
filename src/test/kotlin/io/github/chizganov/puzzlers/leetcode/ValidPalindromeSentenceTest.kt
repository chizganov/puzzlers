package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class ValidPalindromeSentenceTest {

    @ParameterizedTest
    @TestSource(ValidPalindromeSentence::class)
    fun isPalindrome(validPalindromeSentence: ValidPalindromeSentence, input: Path, output: Path) {
        val sentence = input.readLines().first()
        val isPalindromeExpected = output.readLines().first().toBoolean()

        assertEquals(isPalindromeExpected, validPalindromeSentence.isPalindrome(sentence))
    }
}