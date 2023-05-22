package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class SqrtTest {

    @ParameterizedTest
    @TestSource(value = Sqrt::class, implementations = [DumbSqrt::class, BinarySearchSqrt::class])
    fun sqrt(sqrt: Sqrt, input: Path, output: Path) {
        val x = input.readLines().map(String::toInt).single()
        val expectedSqrt = output.readLines().map(String::toInt).single()

        assertEquals(expectedSqrt, sqrt.findSqrt(x))
    }
}