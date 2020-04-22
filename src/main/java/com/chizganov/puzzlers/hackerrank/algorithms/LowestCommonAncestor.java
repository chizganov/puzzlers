package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem">Binary Search Tree : Lowest Common Ancestor challenge</a>
 *
 * @author Ev Chizganov
 */
class LowestCommonAncestor {

    Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1 || root.data == v2) return root;

        Node left = lca(root.left, v1, v2);
        Node right = lca(root.right, v1, v2);

        return left != null ? (right != null ? root : left) : right;
    }

    /*
     * Given class from challenge
     * */
    @SuppressWarnings("Duplicates")
    static class Node {

        private final int data;
        private Node left;
        private Node right;

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

        int getData() {
            return data;
        }

    }

}
