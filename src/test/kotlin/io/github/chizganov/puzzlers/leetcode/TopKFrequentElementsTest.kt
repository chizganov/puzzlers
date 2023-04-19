package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertContentEquals

internal class TopKFrequentElementsTest {

    @ParameterizedTest
    @TestSource(TopKFrequentElements::class)
    fun findTopKFrequent(topKFrequentElements: TopKFrequentElements, input: Path, output: Path) {
        val (nums, k) = input.readLines()
            .map { it.split(",").map(String::toInt).toIntArray() }
            .zipWithNext()
            .first().let {
                it.first to it.second.first()
            }
        val expectedTopNums = output.readLines().first().split(",").map(String::toInt).toIntArray()

        assertContentEquals(expectedTopNums, topKFrequentElements.findTopKFrequent(nums, k))
    }
}