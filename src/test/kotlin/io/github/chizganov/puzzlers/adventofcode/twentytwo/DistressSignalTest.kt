package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class DistressSignalTest {

    @ParameterizedTest
    @TestSource(DistressSignal::class)
    fun sumRightOrderPacketsIndices(distressSignal: DistressSignal, input: Path, output: Path) {
        val packets = input.readLines()
        val expectedRightOrderPacketsIndicesSum = output.readLines()[0].toInt()
        assertEquals(expectedRightOrderPacketsIndicesSum, distressSignal.sumRightOrderPacketsIndices(packets))
    }

    @ParameterizedTest
    @TestSource(DistressSignal::class)
    fun getDecoderKey(distressSignal: DistressSignal, input: Path, output: Path) {
        val packets = input.readLines()
        val expectedDecoderKey = output.readLines()[1].toInt()
        assertEquals(expectedDecoderKey, distressSignal.getDecoderKey(packets))
    }
}