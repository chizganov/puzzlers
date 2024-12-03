package io.github.chizganov.puzzlers.adventofcode.twentyfour

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.io.path.readText

class MullItOverTest {

    @ParameterizedTest
    @TestSource(MullItOver::class, pattern = "^mul-[a-zA-Z]+\\d{2}\\.txt\$")
    fun restoreCorruptedMul(mullItOver: MullItOver, input: Path, output: Path) {
        val memorySegment = input.readText()
        val expectedRestoredMulSum = output.readLines().single().toInt()

        mullItOver.restoreCorruptedMul(memorySegment) shouldBe expectedRestoredMulSum
    }

    @ParameterizedTest
    @TestSource(MullItOver::class, pattern = "^domul-[a-zA-Z]+\\d{2}\\.txt\$")
    fun restoreCorruptedDoMul(mullItOver: MullItOver, input: Path, output: Path) {
        val memorySegment = input.readText()
        val expectedRestoredDoMulSum = output.readLines().single().toInt()

        mullItOver.restoreCorruptedDoMul(memorySegment) shouldBe expectedRestoredDoMulSum
    }
}