package com.chizganov.puzzlers.leetcode.thirtyday;

import java.util.LinkedList;
import java.util.Queue;

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

    static class TreeNode {

        private final int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override public String toString() {
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode current = queue.remove();
                if (current != null && (current.getLeft() != null || current.getRight() != null)) {
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
                if (current == null) sb.append("null");
                else sb.append(current.getVal());
                if (!queue.isEmpty()) sb.append(" ");
            }

            return sb.toString();
        }
    }

}
