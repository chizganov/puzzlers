package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class ValidParenthesesTest {

    @ParameterizedTest
    @TestSource(ValidParentheses::class)
    fun isValid(validParentheses: ValidParentheses, input: Path, output: Path) {
        val parentheses = input.readLines().first()
        val expectedValidity = output.readLines().first().toBoolean()

        assertEquals(expectedValidity, validParentheses.isValid(parentheses))
    }
}