package io.github.chizganov.puzzlers.adventofcode.twentyfour

/**
 * Advent of Code 2024 Day 2: Red-Nosed Reports
 * https://adventofcode.com/2024/day/2
 * */
class RedNosedReports {

    fun isSafe(report: List<Int>): Boolean {
        return report.zipWithNext { left, right -> left - right }.let { diffs ->
            diffs.all { diff -> diff in 1..3 } ||
                diffs.all { diff -> diff in -3..-1 }
        }
    }

    fun isSafeWithProblemDampener(report: List<Int>): Boolean {
        if (isSafe(report)) return true

        return report.indices.any { removeIndex ->
            isSafe(report.filterIndexed { index, _ -> index != removeIndex })
        }
    }
}