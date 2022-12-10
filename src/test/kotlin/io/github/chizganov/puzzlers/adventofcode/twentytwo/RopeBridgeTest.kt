package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class RopeBridgeTest {

    @ParameterizedTest
    @TestSource(RopeBridge::class)
    fun findTailVisitedPositionsNumber(ropeBridge: RopeBridge, input: Path, output: Path) {
        val moves = input.readLines()
        val expectedNumberTailVisitedPositions2 = output.readLines()[0].toInt()
        val expectedNumberTailVisitedPositions9 = output.readLines()[1].toInt()
        assertEquals(expectedNumberTailVisitedPositions2, ropeBridge.findTailVisitedPositionsNumber(2, moves))
        assertEquals(expectedNumberTailVisitedPositions9, ropeBridge.findTailVisitedPositionsNumber(10, moves))
    }
}