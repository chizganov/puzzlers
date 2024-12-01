package io.github.chizganov.puzzlers.adventofcode.twentyfour

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

class HistorianHysteriaTest {

    @ParameterizedTest
    @TestSource(HistorianHysteria::class)
    fun sortedTotalDistance(historianHysteria: HistorianHysteria, input: Path, output: Path) {
        val result = output.readLines().first().toInt()
        val (firstList, secondList) = readLists(input)
        assertEquals(result, historianHysteria.sortedTotalDistance(firstList, secondList))
    }

    @ParameterizedTest
    @TestSource(HistorianHysteria::class)
    fun similarityScore(historianHysteria: HistorianHysteria, input: Path, output: Path) {
        val result = output.readLines().last().toInt()
        val (firstList, secondList) = readLists(input)
        assertEquals(result, historianHysteria.similarityScore(firstList, secondList))
    }

    private fun readLists(input: Path): Pair<List<Int>, List<Int>> {
        return input.readLines()
            .map { line ->
                line.split("\\s+".toRegex()).map(String::toInt).let { (a, b) -> a to b }
            }
            .unzip()
    }
}