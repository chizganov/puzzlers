package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.leetcode.util.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/">Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree challenge</a>
 *
 * @author Ev Chizganov
 */
class StringIsValidSeqInBinaryTree {

    boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidRecursive(root, arr, 0);
    }

    private boolean isValidRecursive(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length || node.getVal() != arr[index]) return false;

        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        if (left == null && right == null && index == arr.length - 1) return true;

        return isValidRecursive(left, arr, index + 1) ||
                isValidRecursive(right, arr, index + 1);
    }

}
