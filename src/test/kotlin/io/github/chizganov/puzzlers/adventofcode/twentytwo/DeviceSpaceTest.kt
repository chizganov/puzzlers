package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class DeviceSpaceTest {

    @ParameterizedTest
    @TestSource(DeviceSpace::class)
    fun sumDirectoriesTotalSizeAtMost(deviceSpace: DeviceSpace, input: Path, output: Path) {
        val terminalOutput = input.readLines()
        val atMostValue = 100_000
        val expectedDirectoriesTotalSizeSum = output.readLines()[0].toInt()
        assertEquals(
            expectedDirectoriesTotalSizeSum,
            deviceSpace.sumDirectoriesTotalSizeAtMost(atMostValue, terminalOutput)
        )
    }

    @ParameterizedTest
    @TestSource(DeviceSpace::class)
    fun smallestFreeUpForUpdateDirectorySize(deviceSpace: DeviceSpace, input: Path, output: Path) {
        val terminalOutput = input.readLines()
        val expectedTotalSizeDirectory = output.readLines()[1].toInt()
        assertEquals(
            expectedTotalSizeDirectory,
            deviceSpace.smallestFreeUpForUpdateDirectorySize(terminalOutput)
        )
    }
}