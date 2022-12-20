package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class RegolithReservoirTest {

    @ParameterizedTest
    @TestSource(RegolithReservoir::class)
    fun countRestedSandUnits(regolithReservoir: RegolithReservoir, input: Path, output: Path) {
        val scan = input.readLines()
        val expectedRestedSandUnitsCount = output.readLines()[0].toInt()
        assertEquals(expectedRestedSandUnitsCount, regolithReservoir.countRestedSandUnits(scan))
    }

    @ParameterizedTest
    @TestSource(RegolithReservoir::class/*, pattern = "^[a-zA-Z]+01.txt$"*/)
    fun countRestedSandUnitsUntilSourceBlocked(regolithReservoir: RegolithReservoir, input: Path, output: Path) {
        val scan = input.readLines()
        val expectedRestedSandUnitsCount = output.readLines()[1].toInt()
        assertEquals(expectedRestedSandUnitsCount, regolithReservoir.countRestedSandUnitsUntilSourceBlocked(scan))
    }
}