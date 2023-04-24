package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class CountAndSayTest {

    @ParameterizedTest
    @TestSource(CountAndSay::class)
    fun countAndSay(countAndSay: CountAndSay, input: Path, output: Path) {
        val n = input.readLines().first().toInt()
        val expectedCountAndSayString = output.readLines().first()

        assertEquals(expectedCountAndSayString, countAndSay.countAndSay(n))
    }
}