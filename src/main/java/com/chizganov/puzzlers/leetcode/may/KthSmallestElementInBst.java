package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/">Kth Smallest Element in a BST problem</a>
 *
 * @author Ev Chizganov
 */
class KthSmallestElementInBst {

    int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode currentNode = root;
        TreeNode prevNode = root;

        int count = 0;
        while (count < k && !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            prevNode = stack.pop();
            currentNode = prevNode.getRight();
            count++;
        }

        return prevNode.getVal();
    }

}
