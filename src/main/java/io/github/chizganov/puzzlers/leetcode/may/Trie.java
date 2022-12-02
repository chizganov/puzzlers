package io.github.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/">Trie challenge</a>
 *
 * @author Ev Chizganov
 */
class Trie {

    private final TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.computeIfAbsent(c, TreeNode::new);
            currentNode = currentNode.children.get(c);
        }
        currentNode.children.putIfAbsent(null, null);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) return false;
            currentNode = currentNode.children.get(c);
        }

        return currentNode.children.containsKey(null);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) return false;
            currentNode = currentNode.children.get(c);
        }

        return true;
    }

    private static final class TreeNode {

        char nChar;
        final Map<Character, TreeNode> children = new HashMap<>();

        TreeNode() {
        }

        TreeNode(char c) {
            this.nChar = c;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return nChar == treeNode.nChar;
        }

        @Override public int hashCode() {
            return Objects.hash(nChar);
        }
    }

}
