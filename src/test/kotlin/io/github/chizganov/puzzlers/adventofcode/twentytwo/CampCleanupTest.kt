package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class CampCleanupTest {

    @ParameterizedTest
    @TestSource(CampCleanup::class)
    fun findIdleElvesNumber(campCleanup: CampCleanup, input: Path, output: Path) {
        val assignmentPairs = input.readLines()
        val expectedIdleElvesNumber = output.readLines().first().toInt()
        assertEquals(expectedIdleElvesNumber, campCleanup.findIdleElvesNumber(assignmentPairs))
    }

    @ParameterizedTest
    @TestSource(CampCleanup::class)
    fun findAssignmentOverlapPairsNumber(campCleanup: CampCleanup, input: Path, output: Path) {
        val assignmentPairs = input.readLines()
        val expectedAssignmentOverlapPairsNumber = output.readLines()[1].toInt()
        assertEquals(
            expectedAssignmentOverlapPairsNumber,
            campCleanup.findAssignmentOverlapPairsNumber(assignmentPairs)
        )
    }
}