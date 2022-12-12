package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 12: Hill Climbing Algorithm
 * https://adventofcode.com/2022/day/12
 *
 * Note that you can jump down on any elevation!
 * */
class HillClimbingAlgorithm {

    fun findFewestRequiredStepsToLocation(heightmap: List<String>): Int {
        return with(heightmap.getLocation(START)) {
            bfsGetFewestStepsMap(heightmap)[first][second]
        }
    }

    fun findClosestLowestLocationSteps(heightmap: List<String>): Int =
        bfsGetFewestStepsMap(heightmap).let { stepsMap ->
            heightmap.asSequence()
                .withIndex()
                .flatMap { row -> row.value.withIndex().map { col -> col.value to Pair(row.index, col.index) } }
                .filter { it.first == LOWEST }
                .map { stepsMap[it.second.first][it.second.second] }
                .filter { it >= 0 }
                .min()
        }

    private fun bfsGetFewestStepsMap(heightmap: List<String>): Array<IntArray> {
        // from finish point to have the closest routes to finish location
        val startLocation = heightmap.getLocation(FINISH)
        val stepsMap = Array(heightmap.size) {
            IntArray(heightmap.first().length) { -1 }
        }.apply { this[startLocation.first][startLocation.second] = 0 }
        var moves = listOf(startLocation)

        while (moves.isNotEmpty()) {
            moves = moves.asSequence()
                .flatMap { heightmap.reachableMoves(it.first, it.second, stepsMap) }
                .distinct()
                .toList()
        }

        return stepsMap
    }

    private fun List<String>.getLocation(mark: Char): Pair<Int, Int> = this.withIndex()
        .filter { it.value.contains(mark) }
        .map { it.index to it.value.indexOf(mark) }
        .single()

    private fun List<String>.reachableMoves(y: Int, x: Int, stepsMap: Array<IntArray>): List<Pair<Int, Int>> =
        listOfNotNull(
            checkMoveReachability(y, x, -1, 0, stepsMap),
            checkMoveReachability(y, x, 1, 0, stepsMap),
            checkMoveReachability(y, x, 0, -1, stepsMap),
            checkMoveReachability(y, x, 0, 1, stepsMap),
        )

    private fun List<String>.checkMoveReachability(
        y: Int,
        x: Int,
        dy: Int,
        dx: Int,
        stepsMap: Array<IntArray>
    ): Pair<Int, Int>? {
        return if (y + dy in 0..lastIndex &&
            x + dx in 0..first().lastIndex &&
            stepsMap[y + dy][x + dx] == -1 &&
            (this[y][x].isLowerCase() && this[y + dy][x + dx].isLowerCase() &&
                    this[y + dy][x + dx].code - this[y][x].code >= -1 ||
                    this[y + dy][x + dx] == START && this[y][x] == LOWEST ||
                    this[y + dy][x + dx] == 'z' && this[y][x] == FINISH)
        ) {
            stepsMap[y + dy][x + dx] = stepsMap[y][x] + 1
            Pair(y + dy, x + dx)
        } else {
            null
        }
    }

    companion object {
        private const val START = 'S'
        private const val FINISH = 'E'
        private const val LOWEST = 'a'
    }
}