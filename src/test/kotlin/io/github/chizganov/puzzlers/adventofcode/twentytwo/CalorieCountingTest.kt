package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class CalorieCountingTest {

    @ParameterizedTest
    @TestSource(CalorieCounting::class)
    fun findNMostCaloriesSum(calorieCounting: CalorieCounting, input: Path, output: Path) {
        val results = output.readLines()
        assertEquals(results[0].toInt(), calorieCounting.findNMostCaloriesSum(input, 1))
        assertEquals(results[1].toInt(), calorieCounting.findNMostCaloriesSum(input, 3))
    }
}