package io.github.chizganov.puzzlers.leetcode.util;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;

/**
 * Binary tree implementation for leetcode challenges.
 * <p>
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * </pre>
 */
public class TreeNode {

    private final int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @SuppressWarnings("unused") public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createBinaryTreeFromBfsString(String bfsString, String delimiter, String nilLeaf) {
        requireNonNull(bfsString);
        requireNonNull(delimiter);
        requireNonNull(nilLeaf);

        String[] nodes = bfsString.split(delimiter);
        if (nodes.length >= 1 && nodes[0].equals(nilLeaf)) return null;

        TreeNode root = new TreeNode(parseInt(nodes[0]));

        Queue<TreeNode> nodeQueue = new ArrayDeque<>(nodes.length);
        nodeQueue.add(root);
        TreeNode current;
        for (int i = 1; i < nodes.length; i += 2) {
            current = nodeQueue.remove();
            if (!nodes[i].equals(nilLeaf)) {
                TreeNode left = new TreeNode(parseInt(nodes[i]));
                current.setLeft(left);
                nodeQueue.add(left);
            }
            if (i + 1 < nodes.length && !nodes[i + 1].equals(nilLeaf)) {
                TreeNode right = new TreeNode(parseInt(nodes[i + 1]));
                current.setRight(right);
                nodeQueue.add(right);
            }
        }

        return root;
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
