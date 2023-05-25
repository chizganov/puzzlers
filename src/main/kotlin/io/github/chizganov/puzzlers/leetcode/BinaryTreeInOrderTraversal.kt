package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode

interface BinaryTreeInOrderTraversal {
    fun traverse(root: TreeNode?): List<Int>
}

class LoopBinaryTreeInOrderTraversal : BinaryTreeInOrderTraversal {
    override fun traverse(root: TreeNode?): List<Int> {
        val traversalList = mutableListOf<TreeNode>()
        val visitedValues = mutableListOf<Int>()
        var node = root

        while (node != null || traversalList.isNotEmpty()) {
            if (node?.left != null) {
                traversalList.add(node)
                node = node.left
            } else if (node?.right != null) {
                visitedValues.add(node.`val`)
                node = node.right
            } else {
                if (node != null) {
                    visitedValues.add(node.`val`)
                    node = null
                }
                if (traversalList.isNotEmpty()) {
                    node = traversalList.removeLast()
                    visitedValues.add(node.`val`)
                    node = node.right
                }
            }
        }

        return visitedValues
    }
}

class RecursiveBinaryTreeInOrderTraversal : BinaryTreeInOrderTraversal {
    override fun traverse(root: TreeNode?): List<Int> =
        mutableListOf<Int>().apply { traverseRecursiveInOrder(root, this) }

    private fun traverseRecursiveInOrder(node: TreeNode?, visitedValues: MutableList<Int>) {
        if (node == null) return
        traverseRecursiveInOrder(node.left, visitedValues)
        visitedValues.add(node.`val`)
        traverseRecursiveInOrder(node.right, visitedValues)
    }
}