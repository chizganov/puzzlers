package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode
import io.github.chizganov.puzzlers.util.TestSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import java.nio.file.Path
import kotlin.io.path.readLines

internal class SymmetricTreeTest {

    @ParameterizedTest
    @TestSource(SymmetricTree::class)
    fun isSymmetric(symmetricTree: SymmetricTree, input: Path, output: Path) {
        val tree = TreeNode.createBinaryTreeFromBfsString(input.readLines().first(), ",", "null")
        val expectedSymmetricity = output.readLines().first().toBoolean()

        assertEquals(expectedSymmetricity, symmetricTree.isSymmetric(tree))
    }
}