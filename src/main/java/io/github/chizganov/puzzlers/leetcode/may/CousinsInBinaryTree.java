package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.leetcode.util.TreeNode;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/">Cousins In Binary Tree challenge</a>
 *
 * @author Ev Chizganov
 */
class CousinsInBinaryTree {

    boolean isCousins(TreeNode root, int x, int y) {
        return !isSiblings(root, x, y) && depth(root, x, 0) == depth(root, y, 0);
    }

    private int depth(TreeNode node, int n, int curDepth) {
        if (node == null) return -1;
        if (node.getVal() == n) return curDepth;

        int leftDepth = depth(node.getLeft(), n, curDepth + 1);
        int rightDepth = depth(node.getRight(), n, curDepth + 1);

        return leftDepth != -1 ? leftDepth : rightDepth;
    }

    private boolean isSiblings(TreeNode node, int x, int y) {
        if (node == null) return false;

        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();

        if (containsVal(left, x) || containsVal(left, y)) {
            return containsVal(right, x) || containsVal(right, y);
        } else {
            return isSiblings(left, x, y) || isSiblings(right, x, y);
        }
    }

    private boolean containsVal(TreeNode node, int val) {
        return node != null && node.getVal() == val;
    }

}
