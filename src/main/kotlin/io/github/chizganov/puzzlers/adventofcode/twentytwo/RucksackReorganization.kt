package io.github.chizganov.puzzlers.adventofcode.twentytwo

/**
 * Advent of Code 2022 <a href="https://adventofcode.com/2022/day/3">Day 3: Rucksack Reorganization</a>
 * */
class RucksackReorganization {
    fun findTotalRearrangementPriority(rucksacks: List<String>): Int {
        var totalPriority = 0
        val compartmentSet = mutableSetOf<Char>()
        rucksacks.forEach { rucksack ->
            for (i in 0..rucksack.lastIndex / 2) {
                compartmentSet.add(rucksack[i])
            }
            for (i in rucksack.lastIndex / 2 + 1..rucksack.lastIndex) {
                val item = rucksack[i]
                if (compartmentSet.contains(item)) {
                    totalPriority += checkNotNull(PRIORITY[item])
                    break
                }
            }
            compartmentSet.clear()
        }
        return totalPriority
    }

    fun findTotalBadgePriority(rucksacks: List<String>): Int {
        var totalPriority = 0
        val groupSize = 3
        for (i in 0..rucksacks.lastIndex step groupSize) {
            val badge = rucksacks.slice(i..i.plus(groupSize).minus(1)).map { it.toSet() }
                .reduce(Set<Char>::intersect).single()
            totalPriority += checkNotNull(PRIORITY[badge])
        }
        return totalPriority
    }

    companion object {
        private val PRIORITY = 'a'.rangeTo('z').associateWith { it.code.minus('a'.code).plus(1) }
            .plus('A'.rangeTo('Z').associateWith { it.code.minus('A'.code).plus(27) })
    }
}