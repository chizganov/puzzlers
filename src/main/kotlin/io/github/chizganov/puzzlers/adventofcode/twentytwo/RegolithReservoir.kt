package io.github.chizganov.puzzlers.adventofcode.twentytwo

import kotlin.math.max
import kotlin.math.sign

/**
 * Advent of Code 2022 Day 14: Regolith Reservoir
 * https://adventofcode.com/2022/day/14
 * */
class RegolithReservoir {

    fun countRestedSandUnitsUntilSourceBlocked(scan: List<String>): Int {
        val structure = buildRockStructure(scan, isAbyss = false)
        var sandVolume = 0
        while (structure[SAND_SOURCE_POSITION.first][SAND_SOURCE_POSITION.second] == SOURCE) {
            var curX = SAND_SOURCE_POSITION.first
            var curY = structure[curX].indexOfFirst { it.isBlocker() }
            while (!structure[curX - 1][curY].isBlocker() || !structure[curX + 1][curY].isBlocker()) {
                when {
                    !structure[curX - 1][curY].isBlocker() -> curX--
                    !structure[curX + 1][curY].isBlocker() -> curX++
                }
                curY = structure[curX].indexOfBlockerStarting(curY)
            }
            structure[curX][curY - 1] = SAND
            sandVolume++
        }
        return sandVolume
    }

    fun countRestedSandUnits(scan: List<String>): Int {
        val structure = buildRockStructure(scan, isAbyss = true)
        var sandVolume = 0
        var isNotAbyss = true
        while (isNotAbyss) {
            var curX = SAND_SOURCE_POSITION.first
            var curY = structure[curX].indexOfFirst { it.isBlocker() }
            while ((curY != -1 && (!structure[curX - 1][curY].isBlocker() || !structure[curX + 1][curY].isBlocker()))) {
                when {
                    !structure[curX - 1][curY].isBlocker() -> curX--
                    !structure[curX + 1][curY].isBlocker() -> curX++
                }
                curY = structure[curX].indexOfBlockerStarting(curY)
            }
            if (curY == -1) isNotAbyss = false
            else {
                structure[curX][curY - 1] = SAND
                sandVolume++
            }
        }
        return sandVolume
    }

    private fun buildRockStructure(scan: List<String>, isAbyss: Boolean): Array<CharArray> {
        val cleanedScan = scan.map { it.split(" -> ", ",").map(String::toInt).chunked(2) }
        val maxStoneDepth = cleanedScan.asSequence()
            .map { shape -> shape.map { linePoints -> linePoints[1] } }.flatten().max()
        val maxStoneBreadth = cleanedScan.asSequence()
            .map { shape -> shape.map { linePoints -> linePoints[0] } }.flatten().max()
        val structure = Array(maxStoneDepth + FLOOR_DISTANCE + max(SAND_SOURCE_POSITION.first + 1, maxStoneBreadth)) {
            CharArray(maxStoneDepth + FLOOR_DISTANCE + 1) {
                // fill floor if not abyss
                if (!isAbyss && it == maxStoneDepth + FLOOR_DISTANCE) '#' else '.'
            }
        }
        structure[SAND_SOURCE_POSITION.first][SAND_SOURCE_POSITION.second] = SOURCE
        // fill stone structure
        cleanedScan.forEach { shape ->
            shape.zipWithNext().forEach { (from, to) ->
                val (dx, dy) = (0..1).map { (to[it] - from[it]).sign }
                var curX = from[0]
                var curY = from[1]
                while (curX != to[0] || curY != to[1]) {
                    structure[curX][curY] = STONE
                    curX += dx
                    curY += dy
                }
                structure[curX][curY] = STONE
            }
        }
        return structure
    }

    private fun Char.isBlocker() = this == SAND || this == STONE
    private fun CharArray.indexOfBlockerStarting(starting: Int): Int {
        var i = starting
        while (i < size && !this[i].isBlocker()) i++
        return if (i < size) i else -1
    }

    companion object {
        private const val SAND = '0'
        private const val STONE = '#'
        private const val SOURCE = '+'
        private const val FLOOR_DISTANCE = 2
        private val SAND_SOURCE_POSITION = Pair(500, 0)
    }
}