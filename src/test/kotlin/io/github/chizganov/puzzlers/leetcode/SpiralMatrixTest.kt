package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class SpiralMatrixTest {

    @ParameterizedTest
    @TestSource(SpiralMatrix::class)
    fun spiralOrder(spiralMatrix: SpiralMatrix, input: Path, output: Path) {
        val matrix: Array<IntArray> = input.readLines().map {
            it.split(",").map(String::toInt).toIntArray()
        }.toTypedArray()
        val expectedSpiralArray = output.readLines().first().split(",").map(String::toInt).toList()
        assertEquals(expectedSpiralArray, spiralMatrix.spiralOrder(matrix))
    }
}