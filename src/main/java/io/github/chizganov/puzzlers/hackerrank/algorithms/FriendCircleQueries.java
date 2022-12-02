package io.github.chizganov.puzzlers.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/friend-circle-queries/problem">Friend Circle Queries challenge</a>
 *
 * @author Ev Chizganov
 */
class FriendCircleQueries {

    int[] maxCircle(int[][] queries) {
        int[] maxCircles = new int[queries.length];
        FriendDisjointSet set = new FriendDisjointSet();

        for (int i = 0; i < queries.length; i++) {
            set.union(queries[i][0], queries[i][1]);
            maxCircles[i] = set.getMaxSize();
        }

        return maxCircles;
    }

    private static class FriendDisjointSet {

        final Map<Integer, Node> nodeToParent = new HashMap<>();
        int maxSize = 1;

        void union(int n1, int n2) {
            if (!nodeToParent.containsKey(n1)) nodeToParent.put(n1, new Node(n1));
            if (!nodeToParent.containsKey(n2)) nodeToParent.put(n2, new Node(n2));

            Node root1 = root(nodeToParent.get(n1).node);
            Node root2 = root(nodeToParent.get(n2).node);

            if (root1.node == root2.node) return;

            int unionSize = root1.size + root2.size;
            if (root1.size >= root2.size) {
                nodeToParent.replace(root2.node, root1);
                root1.size = unionSize;
            } else {
                nodeToParent.replace(root1.node, root2);
                root2.size = unionSize;
            }

            if (unionSize > maxSize) maxSize = unionSize;
        }

        private Node root(int node) {
            int n = node;
            while (nodeToParent.get(n).node != n) {
                int t = nodeToParent.get(n).node;
                nodeToParent.replace(n, nodeToParent.get(t));
                n = t;
            }

            return nodeToParent.get(n);
        }

        int getMaxSize() {
            return maxSize;
        }

        private static final class Node {
            final int node;
            int size;

            Node(int node) {
                this.node = node;
                size = 1;
            }

        }

    }

}
