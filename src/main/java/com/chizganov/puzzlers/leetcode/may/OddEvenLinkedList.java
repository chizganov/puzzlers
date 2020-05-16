package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.leetcode.util.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/">Odd Even Linked List problem</a>
 *
 * @author Ev Chizganov
 */
class OddEvenLinkedList {

    ListNode oddEvenList(ListNode head) {
        if (head == null || head.getNext() == null) return head;

        ListNode evenList = head.getNext();
        ListNode currentNode = evenList.getNext();
        ListNode currentOddNode = head;
        ListNode currentEvenNode = evenList;

        boolean isEvenNode = false;
        while (currentNode != null) {
            if (isEvenNode) {
                currentEvenNode.setNext(currentNode);
                currentEvenNode = currentEvenNode.getNext();
            } else {
                currentOddNode.setNext(currentNode);
                currentOddNode = currentOddNode.getNext();
            }

            currentNode = currentNode.getNext();
            isEvenNode = !isEvenNode;
        }
        currentOddNode.setNext(evenList);
        currentEvenNode.setNext(null);

        return head;
    }

}
