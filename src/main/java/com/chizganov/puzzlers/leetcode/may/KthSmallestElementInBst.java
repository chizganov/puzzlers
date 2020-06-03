package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/">Kth Smallest Element in a BST problem</a>
 *
 * @author Ev Chizganov
 */
class KthSmallestElementInBst {

    int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();

        TreeNode currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getLeft();
        }

        TreeNode prevNode = stack.peek();
        int count = 0;
        while (count < k && !stack.isEmpty()) {
            currentNode = stack.peek();
            // First go left if not visited yet
            if (currentNode.getLeft() != null && prevNode != currentNode.getLeft() && prevNode != currentNode.getRight()) {
                stack.push(currentNode.getLeft());
            } else {
                // Go right if not visited yet
                if (currentNode.getRight() != null && prevNode != currentNode.getRight()) {
                    stack.push(currentNode.getRight());
                }
                if (visitedSet.add(currentNode.getVal())) count++;
            }
            // Go up if current subtree already traversed
            if (currentNode == stack.peek()) {
                stack.pop();
            }

            prevNode = currentNode;
        }

        return requireNonNull(prevNode).getVal();
    }

}
