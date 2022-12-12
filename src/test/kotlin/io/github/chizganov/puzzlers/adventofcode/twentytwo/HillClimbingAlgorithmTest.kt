package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class HillClimbingAlgorithmTest {

    @ParameterizedTest
    @TestSource(HillClimbingAlgorithm::class)
    fun findFewestRequiredStepsToLocation(hillClimbingAlgorithm: HillClimbingAlgorithm, input: Path, output: Path) {
        val heightmap = input.readLines()
        val expectedFewestSteps = output.readLines()[0].toInt()
        assertEquals(expectedFewestSteps, hillClimbingAlgorithm.findFewestRequiredStepsToLocation(heightmap))
    }

    @ParameterizedTest
    @TestSource(HillClimbingAlgorithm::class)
    fun findClosestLowestLocation(hillClimbingAlgorithm: HillClimbingAlgorithm, input: Path, output: Path) {
        val heightmap = input.readLines()
        val expectedLowestClosestLocationSteps = output.readLines()[1].toInt()
        assertEquals(
            expectedLowestClosestLocationSteps,
            hillClimbingAlgorithm.findClosestLowestLocationSteps(heightmap)
        )
    }
}