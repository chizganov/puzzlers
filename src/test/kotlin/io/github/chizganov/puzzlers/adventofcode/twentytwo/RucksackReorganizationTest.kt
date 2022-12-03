package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class RucksackReorganizationTest {

    @ParameterizedTest
    @TestSource(RucksackReorganization::class)
    fun findTotalRearrangementPriority(rucksackReorganization: RucksackReorganization, input: Path, output: Path) {
        val rucksacks = input.readLines()
        val expectedTotalPriority = output.readLines().first().toInt()
        assertEquals(expectedTotalPriority, rucksackReorganization.findTotalRearrangementPriority(rucksacks))
    }

    @ParameterizedTest
    @TestSource(RucksackReorganization::class)
    fun findTotalBadgePriority(rucksackReorganization: RucksackReorganization, input: Path, output: Path) {
        val rucksacks = input.readLines()
        val expectedTotalBadgePriority = output.readLines()[1].toInt()
        assertEquals(expectedTotalBadgePriority, rucksackReorganization.findTotalBadgePriority(rucksacks))
    }
}