package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
class SymmetricTree {

    @Suppress("KotlinConstantConditions")
    fun isSymmetric(root: TreeNode?): Boolean {
        var isSymmetric = true
        val visitNodesLeft: MutableList<TreeNode?> = mutableListOf(root?.left)
        val visitNodesRight: MutableList<TreeNode?> = mutableListOf(root?.right)
        while (isSymmetric && visitNodesLeft.isNotEmpty() && visitNodesRight.isNotEmpty()) {
            val left = visitNodesLeft.removeFirst()
            val right = visitNodesRight.removeFirst()
            when {
                left == null && right != null || left != null && right == null -> isSymmetric = false
                left == null && right == null -> isSymmetric = true
                left?.`val` != right?.`val` -> isSymmetric = false
                else -> {
                    visitNodesLeft.add(left?.left)
                    visitNodesLeft.add(left?.right)
                    visitNodesRight.add(right?.right)
                    visitNodesRight.add(right?.left)
                }
            }
        }

        return isSymmetric
    }

}