package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class TreetopTreeHouseTest {

    @ParameterizedTest
    @TestSource(TreetopTreeHouse::class)
    fun findVisibleTreesNumber(treetopTreeHouse: TreetopTreeHouse, input: Path, output: Path) {
        val gridMap = input.readLines()
        val expectedVisibleTreesNumber = output.readLines().first().toInt()
        assertEquals(expectedVisibleTreesNumber, treetopTreeHouse.findVisibleTreesNumber(gridMap))
    }

    @ParameterizedTest
    @TestSource(TreetopTreeHouse::class)
    fun findHighestScenicScore(treetopTreeHouse: TreetopTreeHouse, input: Path, output: Path) {
        val gridMap = input.readLines()
        val expectedHighestScenicScore = output.readLines()[1].toInt()
        assertEquals(expectedHighestScenicScore, treetopTreeHouse.findHighestScenicScore(gridMap))
    }
}