package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 <a href="https://adventofcode.com/2022/day/2">Day 2: Rock Paper Scissors</a>
 * */
class RockPaperScissors {
    fun calculateTotalScore(strategy: ScoreCalculationStrategy, results: List<String>): Int {
        return results.sumOf { requireNotNull(strategy.scoreMap[it]) }
    }

    enum class ScoreCalculationStrategy(val scoreMap: Map<String, Int>) {
        HAND_SHAPE(HAND_SHAPE_COMBINATIONS),
        RESULT(RESULT_COMBINATIONS)
    }

    companion object {
        /*
        * A, X - rock - 1;
        * B, Y - paper - 2,
        * C, Z - scissors - 3;
        * rock < paper < scissors < rock
        * X - lose - 0
        * Y - draw - 3
        * Z - win - 6
        * HAND_SHAPE_COMBINATIONS - part 1
        * RESULT_COMBINATIONS - part 2
        * */
        private val HAND_SHAPE_COMBINATIONS = mapOf(
            "A X" to 4,
            "A Y" to 8,
            "A Z" to 3,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 7,
            "C Y" to 2,
            "C Z" to 6,
        )
        private val RESULT_COMBINATIONS = mapOf(
            "A X" to 3,
            "A Y" to 4,
            "A Z" to 8,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 2,
            "C Y" to 6,
            "C Z" to 7,
        )
    }
}

