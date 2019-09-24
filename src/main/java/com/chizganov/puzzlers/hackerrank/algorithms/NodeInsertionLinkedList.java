package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem">Insert a node at a specific position in a linked list challenge</a>
 *
 * @author Ev Chizganov
 */
class NodeInsertionLinkedList {

    SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode current = head;
        for (int i = 0; i < position - 1; i++) current = current.next;

        SinglyLinkedListNode newNode = new SinglyLinkedListNode();
        newNode.data = data;
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    static class SinglyLinkedListNode {

        int data;
        SinglyLinkedListNode next;

        static SinglyLinkedListNode create(int... data) {
            if (data.length == 0) throw new IllegalStateException();

            SinglyLinkedListNode head = new SinglyLinkedListNode();
            head.data = data[0];

            SinglyLinkedListNode current = head;
            for (int i = 1; i < data.length; i++) {
                current.next = new SinglyLinkedListNode();
                current = current.next;
                current.data = data[i];
            }

            return head;
        }

        int[] array() {
            StringBuilder sb = new StringBuilder();
            SinglyLinkedListNode current = this;
            do {
                sb.append(current.data).append(' ');
                current = current.next;
            } while (current != null);

            return Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

}
