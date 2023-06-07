package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class RomanToIntTest {

    @ParameterizedTest
    @TestSource(value = RomanToInt::class, implementations = [RuleRomanToInt::class, DumbRomanToInt::class])
    fun convert(romanToInt: RomanToInt, input: Path, output: Path) {
        val roman = input.readLines().single()
        val expectedConvertedInt = output.readLines().single().toInt()

        romanToInt.convert(roman) shouldBeEqual expectedConvertedInt
    }
}