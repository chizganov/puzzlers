package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class ClimbingStairsTest {

    @ParameterizedTest
    @TestSource(ClimbingStairs::class)
    fun climbStairs(climbingStairs: ClimbingStairs, input: Path, output: Path) {
        val n = input.readLines().first().toInt()
        val expectedClimbs = output.readLines().first().toInt()

        assertEquals(expectedClimbs, climbingStairs.climbStairs(n))
    }
}