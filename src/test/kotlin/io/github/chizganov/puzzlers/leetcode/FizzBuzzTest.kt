package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertContentEquals

internal class FizzBuzzTest {

    @ParameterizedTest
    @TestSource(FizzBuzz::class)
    fun fizzBuzz(fizzBuzz: FizzBuzz, input: Path, output: Path) {
        val number = input.readLines().first().toInt()
        val expectedAnswer = output.readLines().first().split(",")
        assertContentEquals(expectedAnswer, fizzBuzz.fizzBuzz(number))
    }
}