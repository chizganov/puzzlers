package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode
import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

internal class BinaryTreeInOrderTraversalTest {

    @ParameterizedTest
    @TestSource(
        value = BinaryTreeInOrderTraversal::class,
        implementations = [LoopBinaryTreeInOrderTraversal::class, RecursiveBinaryTreeInOrderTraversal::class],
    )
    fun traverse(binaryTreeInOrderTraversal: BinaryTreeInOrderTraversal, input: Path, output: Path) {
        val root = input.readLines().firstOrNull()?.let {
            TreeNode.createBinaryTreeFromBfsString(it, ",", "null")
        }
        val expectedTraversedValuesList =
            output.readLines().firstOrNull()?.split(",")?.map(String::toInt) ?: emptyList()

        assertEquals(expectedTraversedValuesList, binaryTreeInOrderTraversal.traverse(root))
    }
}