package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 Day 4: Camp Cleanup
 * https://adventofcode.com/2022/day/4
 * */
open class CampCleanup {

    open fun findIdleElvesNumber(
        assignmentPairs: List<String>
    ): Int = assignmentPairs
        .asSequence()
        .flatMap { it.split(',', '-') }
        .map(String::toInt)
        .chunked(2)
        .map { assignmentRange -> assignmentRange[0].rangeTo(assignmentRange[1]) }
        .chunked(2)
        .count { (range1, range2) -> range1 includes range2 || range2 includes range1 } // set's containsAll can be used

    open fun findAssignmentOverlapPairsNumber(assignmentPairs: List<String>): Int = assignmentPairs
        .asSequence()
        .flatMap { it.split(',', '-') }
        .map(String::toInt)
        .chunked(2)
        .map { assignmentRange -> assignmentRange[0].rangeTo(assignmentRange[1]) }
        .chunked(2)
        .count { (range1, range2) -> range1 intersects range2 } // set's intersect can be used

    private infix fun IntRange.includes(range: IntRange) = this.first <= range.first && this.last >= range.last
    private infix fun IntRange.intersects(range: IntRange) =
        this.first >= range.first && this.first <= range.last || this.first <= range.first && this.last >= range.first
}