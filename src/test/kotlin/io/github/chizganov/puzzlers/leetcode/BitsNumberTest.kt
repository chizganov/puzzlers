package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class BitsNumberTest {

    @ParameterizedTest
    @TestSource(BitsNumber::class)
    fun hammingWeight(bitsNumber: BitsNumber, input: Path, output: Path) {
        val n = input.readLines().first().toUInt(2).toInt()
        val expectedBitsCount = output.readLines().first().toInt()
        assertEquals(expectedBitsCount, BitsNumber().hammingWeight(n))
    }
}