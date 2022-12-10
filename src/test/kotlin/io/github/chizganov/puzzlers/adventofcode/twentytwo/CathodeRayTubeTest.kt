package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class CathodeRayTubeTest {

    @ParameterizedTest
    @TestSource(CathodeRayTube::class, implementations = [ComplexCathodeRayTube::class, SimpleCathodeRayTube::class])
    fun sumSignalStrengths(cathodeRayTube: CathodeRayTube, input: Path, output: Path) {
        val program = input.readLines()
        val expectedSumOfSignalStrength = output.readLines()[0].toInt()
        assertEquals(expectedSumOfSignalStrength, cathodeRayTube.sumSignalStrengths(program))
    }

    @ParameterizedTest
    @TestSource(CathodeRayTube::class, implementations = [ComplexCathodeRayTube::class, SimpleCathodeRayTube::class])
    fun renderCrtImage(cathodeRayTube: CathodeRayTube, input: Path, output: Path) {
        val program = input.readLines()
        val expectedRenderedImage = output.readLines().drop(1)
        val actualRenderedImage = cathodeRayTube.renderCrtImage(program)
        println(actualRenderedImage.joinToString("\n"))
        assertEquals(expectedRenderedImage, actualRenderedImage)
    }
}