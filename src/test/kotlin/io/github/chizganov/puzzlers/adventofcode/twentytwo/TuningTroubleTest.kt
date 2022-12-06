package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class TuningTroubleTest {

    @ParameterizedTest
    @TestSource(TuningTrouble::class)
    fun findFirstMarkerOccurrence(tuningTrouble: TuningTrouble, input: Path, output: Path) {
        val buffer = input.readLines().single()
        val expectedFirstMarkerOccurrence = output.readLines().map(String::toInt)
        assertEquals(
            expectedFirstMarkerOccurrence[0],
            tuningTrouble.findFirstMarkerOccurrence(4, buffer)
        )
        assertEquals(
            expectedFirstMarkerOccurrence[1],
            tuningTrouble.findFirstMarkerOccurrence(14, buffer)
        )
    }
}