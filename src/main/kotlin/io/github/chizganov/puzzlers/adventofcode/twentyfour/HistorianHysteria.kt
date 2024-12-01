package io.github.chizganov.puzzlers.adventofcode.twentyfour

import kotlin.math.absoluteValue

/**
 * Advent of Code 2024 Day 1: Historian Hysteria
 * https://adventofcode.com/2024/day/1
 * */
class HistorianHysteria {

    fun sortedTotalDistance(firstList: List<Int>, secondList: List<Int>): Int {
        return firstList.sorted().zip(secondList.sorted()).sumOf { it.first.minus(it.second).absoluteValue }
    }

    fun similarityScore(firstList: List<Int>, secondList: List<Int>): Int {
        return secondList.groupingBy { it }.eachCount().let { occurrencesInLeft ->
            firstList.sumOf { num -> num * (occurrencesInLeft[num] ?: 0) }
        }
    }

}