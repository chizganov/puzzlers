package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode
import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class BinaryTreeMaxDepthTest {

    @ParameterizedTest
    @TestSource(BinaryTreeMaxDepth::class)
    fun maxDepthRecursively(binaryTreeMaxDepth: BinaryTreeMaxDepth, input: Path, output: Path) {
        val tree = TreeNode.createBinaryTreeFromBfsString(input.readLines().first(), ",", "null")
        val expectedDepth = output.readLines().first().toInt()

        assertEquals(expectedDepth, binaryTreeMaxDepth.findMaxDepthRecursively(tree))
    }
}