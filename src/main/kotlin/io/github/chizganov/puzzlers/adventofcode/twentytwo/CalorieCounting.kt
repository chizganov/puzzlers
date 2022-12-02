package io.github.chizganov.puzzlers.adventofcode.twentytwo

import java.nio.file.Path
import kotlin.io.path.forEachLine
import kotlin.math.max

/**
 * Advent of Code 2022 <a href="https://adventofcode.com/2022/day/1">Day 1: Calorie Counting</a>
 * */
class CalorieCounting {
    fun findNMostCaloriesSum(inputFile: Path, n: Int): Int {
        var calories = 0
        val topElves = IntArray(n)
        inputFile.forEachLine { line ->
            if (line.isNotEmpty()) {
                calories += line.toInt()
            } else {
                topElves[0] = max(topElves[0], calories)
                for (i in 1..topElves.lastIndex) {
                    if (topElves[i - 1] > topElves[i]) {
                        topElves[i] = topElves[i - 1].also { topElves[i - 1] = topElves[i] }
                    }
                }
                calories = 0
            }
        }

        return topElves.sum()
    }
}