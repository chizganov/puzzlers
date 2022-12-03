package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class RockPaperScissorsTest {

    @ParameterizedTest
    @TestSource(RockPaperScissors::class)
    fun calculateTotalScore(rockPaperScissors: RockPaperScissors, input: Path, output: Path) {
        val results = input.readLines()
        val expectedStrategyScore = output.readLines().map { it.toInt() }
        assertEquals(
            expectedStrategyScore[0],
            rockPaperScissors.calculateTotalScore(RockPaperScissors.ScoreCalculationStrategy.HAND_SHAPE, results)
        )
        assertEquals(
            expectedStrategyScore[1],
            rockPaperScissors.calculateTotalScore(RockPaperScissors.ScoreCalculationStrategy.RESULT, results)
        )
    }
}