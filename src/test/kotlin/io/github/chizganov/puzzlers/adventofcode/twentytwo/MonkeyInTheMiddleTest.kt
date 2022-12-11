package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class MonkeyInTheMiddleTest {

    @ParameterizedTest
    @TestSource(MonkeyInTheMiddle::class)
    fun countMonkeyBusinessLevel(monkeyInTheMiddle: MonkeyInTheMiddle, input: Path, output: Path) {
        val notes = input.readLines()
        val expectedMonkeyBusinessLevel = output.readLines()[0].toLong()
        assertEquals(expectedMonkeyBusinessLevel, monkeyInTheMiddle.countMonkeyBusinessLevel(notes))
    }
}