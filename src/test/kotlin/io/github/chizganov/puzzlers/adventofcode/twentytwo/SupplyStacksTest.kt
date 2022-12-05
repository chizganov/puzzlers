package io.github.chizganov.puzzlers.adventofcode.twentytwo

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class SupplyStacksTest {

    @ParameterizedTest
    @TestSource(SupplyStacks::class)
    fun rearrangeAndGetStacksTop(supplyStacks: SupplyStacks, input: Path, output: Path) {
        val supplyStacksInput = input.readLines()
        val expectedResultStacksTop = output.readLines()
        assertEquals(
            expectedResultStacksTop[0],
            supplyStacks.rearrangeAndGetStacksTop(supplyStacksInput, SupplyStacks.CrateMoveStrategy.ONE_BY_ONE)
        )
        assertEquals(
            expectedResultStacksTop[1],
            supplyStacks.rearrangeAndGetStacksTop(supplyStacksInput, SupplyStacks.CrateMoveStrategy.PACK)
        )
    }
}