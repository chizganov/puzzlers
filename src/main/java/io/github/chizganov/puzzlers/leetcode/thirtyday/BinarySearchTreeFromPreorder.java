package io.github.chizganov.puzzlers.leetcode.thirtyday;

import io.github.chizganov.puzzlers.leetcode.util.TreeNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/">Construct Binary Search Tree From Preorder traversal challenge</a>
 *
 * @author Ev Chizganov
 */
class BinarySearchTreeFromPreorder {

    TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            addNode(root, preorder[i]);
        }

        return root;
    }

    private static void addNode(TreeNode node, int num) {
        if (node.getVal() > num) {
            if (node.getLeft() == null) node.setLeft(new TreeNode(num));
            else addNode(node.getLeft(), num);
        } else {
            if (node.getRight() == null) node.setRight(new TreeNode(num));
            else addNode(node.getRight(), num);
        }
    }

}
