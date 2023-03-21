package io.github.chizganov.puzzlers.leetcode

import io.github.chizganov.puzzlers.leetcode.util.TreeNode

/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class BinaryTreeMaxDepth {

    fun findMaxDepthRecursively(root: TreeNode?): Int {
        if (root == null) return 0
        return Integer.max(findMaxDepthRecursively(root.left) + 1, findMaxDepthRecursively(root.right) + 1)
    }
}