package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.leetcode.util.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/">Binary Tree Maximum Path sum challenge</a>
 *
 * @author Ev Chizganov
 */
class BinaryTreeMaxPath {

    int maxPathSum(TreeNode root) {
        return treeStats(root).maxTree;
    }

    private static TreeStats treeStats(TreeNode node) {
        if (node == null) return TreeStats.EMPTY;

        int val = node.getVal();
        TreeStats leftStats = treeStats(node.getLeft());
        TreeStats rightStats = treeStats(node.getRight());

        return new TreeStats(
                max(leftStats.maxPath, rightStats.maxPath, 0) + val,
                max(leftStats.maxTree, rightStats.maxTree,
                        positiveOrZero(leftStats.maxPath) + positiveOrZero(rightStats.maxPath) + val)
        );
    }

    private static int positiveOrZero(int num) {
        return Math.max(num, 0);
    }

    private static int max(int i1, int i2, int i3) {
        return Math.max(Math.max(i1, i2), i3);
    }

    private record TreeStats(int maxPath, int maxTree) {

        private static final TreeStats EMPTY = new TreeStats(0, Integer.MIN_VALUE);

    }

}
