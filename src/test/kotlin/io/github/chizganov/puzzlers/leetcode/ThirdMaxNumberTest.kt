package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class ThirdMaxNumberTest {

    @ParameterizedTest
    @TestSource(
        value = ThirdMaxNumber::class,
        implementations = [ThirdMaxNumber::class, SimpleThirdMaxNumber::class]
    )
    fun thirdMax(thirdMaxNumber: ThirdMaxNumber, input: Path, output: Path) {
        val nums = input.readLines().single().split(',').map(String::toInt).toIntArray()
        val expectedMaxNumber = output.readLines().single().toInt()
        assertEquals(expectedMaxNumber, thirdMaxNumber.thirdMax(nums))
    }
}