package io.github.chizganov.puzzlers.adventofcode.twentytwo

import kotlin.math.sign

/**
 * Advent of Code 2022 Day 9: Rope Bridge
 * https://adventofcode.com/2022/day/9
 * */
class RopeBridge {

    private val commandToDiffPosition = mapOf(
        "U" to Pair(1, 0),
        "R" to Pair(0, 1),
        "D" to Pair(-1, 0),
        "L" to Pair(0, -1),
    )

    fun findTailVisitedPositionsNumber(ropeLength: Int, moves: List<String>): Int {
        val tailPositions = mutableSetOf<Pair<Int, Int>>()
        val rope = Rope(ropeLength)
        moves.map { it.split(" ") }.forEach { command ->
            val dp = requireNotNull(commandToDiffPosition[command[0]])
            repeat(command[1].toInt()) {
                rope.move(dp.first, dp.second)
                tailPositions.add(rope.chunks.last())
            }
        }
        return tailPositions.size
    }

    private class Rope(val length: Int) {
        val chunks = (0 until length).map { Pair(0, 0) }.toMutableList()

        fun move(dy: Int, dx: Int) {
            chunks[0] = chunks[0].relPosition(dy, dx)
            (1 until length).forEach { i ->
                if (isAdjacentEnds(chunks[i], chunks[i - 1])) return
                chunks[i] = chunks[i].relPosition(
                    (chunks[i - 1].first - chunks[i].first).sign,
                    (chunks[i - 1].second - chunks[i].second).sign
                )
            }
        }

        private fun isAdjacentEnds(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>): Boolean =
            pos1 in (-1..1).flatMap { dy ->
                (-1..1).map { dx -> pos2.relPosition(dy, dx) }
            }

        private fun Pair<Int, Int>.relPosition(dy: Int, dx: Int) = first + dy to second + dx
    }
}