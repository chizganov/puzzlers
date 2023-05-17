package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.util.TestSource
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class TwoArrayIntersectionIITest {

    @ParameterizedTest
    @TestSource(TwoArrayIntersectionII::class)
    fun intersect(twoArrayIntersectionII: TwoArrayIntersectionII, input: Path, output: Path) {
        val (nums1, nums2) = input.readLines().map { it.split(",").map(String::toInt).toIntArray() }
            .zipWithNext()
            .first()
        val expectedIntersection = output.readLines().map { it.split(",").map(String::toInt).toTypedArray() }.first()
        val intersection = twoArrayIntersectionII.intersect(nums1, nums2).toTypedArray()

        intersection shouldContainExactlyInAnyOrder expectedIntersection
    }
}