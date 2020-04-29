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
        final int val = node.getVal();
        final TreeNode leftNode = node.getLeft();
        final TreeNode rightNode = node.getRight();

        if (leftNode == null && rightNode == null) return new TreeStats(val, val);
        else if (leftNode == null || rightNode == null) {
            TreeNode nonNullNode = leftNode != null ? leftNode : rightNode;
            TreeStats stats = treeStats(nonNullNode);
            return new TreeStats(positiveOrZero(stats.maxPath) + val, max(stats.maxTree, stats.maxPath + val, val));
        }

        TreeStats leftStats = treeStats(leftNode);
        TreeStats rightStats = treeStats(rightNode);

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

    private static class TreeStats {

        private final int maxPath;
        private final int maxTree;

        TreeStats(int maxPath, int maxTree) {
            this.maxPath = maxPath;
            this.maxTree = maxTree;
        }

    }

}
