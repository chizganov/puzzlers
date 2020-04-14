package com.chizganov.puzzlers.leetcode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers challenge</a>
 *
 * @author Ev Chizganov
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curNode = result;
        int reminder = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + reminder;
            reminder = sum / 10;

            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            int sum = l.val + reminder;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            l = l.next;
            reminder = sum / 10;
        }

        if (reminder > 0) {
            curNode.next = new ListNode(reminder);
        }

        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            if (val != listNode.val) return false;

            return next == null || next.equals(listNode.next);
        }

    }

}
