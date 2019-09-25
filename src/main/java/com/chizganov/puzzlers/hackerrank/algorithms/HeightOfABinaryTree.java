package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem">Height of a binary tree challenge</a>
 *
 * @author Ev Chizganov
 */
class HeightOfABinaryTree {

    int height(Node root) {
        return root == null ? -1 : (height(root.left) > height(root.right) ? height(root.left) : height(root.right)) + 1;
    }

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        static Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            } else {
                Node cur;
                if (data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

    }

}
