package com.chizganov.puzzlers.leetcode.util;

import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;

/**
 * <pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 */
@SuppressWarnings("unused")
public class ListNode {

    private final int val;
    private ListNode next;

    public ListNode() {
        val = 0;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createFromString(String listString, String pointer, String nullNode) {
        requireNonNull(listString);
        requireNonNull(pointer);

        String[] nodes = listString.split(pointer);
        if (nodes.length == 0) {
            throw new IllegalArgumentException(
                    String.format("Cannot create list from '%s' string and %s pointer.", listString, pointer)
            );
        }

        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 0; i < nodes.length && !nodes[i].equals(nullNode); i++) {
            current.setNext(new ListNode(parseInt(nodes[i])));
            current = current.next;
        }

        return head.next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override public String toString() {
        return String.format("%d->%s", val, next != null ? next.toString() : "NULL");
    }
}
