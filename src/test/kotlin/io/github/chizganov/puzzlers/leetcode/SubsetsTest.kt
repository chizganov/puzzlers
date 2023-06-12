package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class SubsetsTest {

    @ParameterizedTest
    @TestSource(Subsets::class)
    fun subsets(subsets: Subsets, input: Path, output: Path) {
        val nums = input.readLines().single().split(",").map(String::toInt).toIntArray()
        val expectedSubsets = "\\[(.*?)]".toRegex()
            .findAll(output.readLines().single())
            .map { match ->
                match.groupValues[1].let { listElement ->
                    if (listElement.isBlank()) emptyList()
                    else listElement.split(",").map { it.toInt() }
                }
            }
            .toList()

        subsets.findSubsets(nums) shouldContainExactlyInAnyOrder expectedSubsets
    }
}