package com.leetcode.medium;

public class PartitionList86 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(final int x) {
            this.val = x;
        }
    }

    public static ListNode partition(ListNode head, final int x) {
        ListNode headCopy = head;
        ListNode h = null;
        ListNode t = null;
        while (headCopy != null) {
            final ListNode l = new ListNode(headCopy.val);
            if (l.val < x) {
                l.next = h;
                h = l;
            } else {
                l.next = t;
                t = l;
            }
            headCopy = headCopy.next;
        }
        head = null;
        while (t != null) {
            final ListNode l = new ListNode(t.val);
            l.next = head;
            head = l;
            t = t.next;
        }
        while (h != null) {
            final ListNode l = new ListNode(h.val);
            l.next = head;
            head = l;
            h = h.next;
        }
        return head;
    }

    public static void main(final String[] args) {
        final ListNode test = new ListNode(2);
        final ListNode test2 = new ListNode(3);
        final ListNode test3 = new ListNode(1);
        final ListNode test4 = new ListNode(2);
        final ListNode test5 = new ListNode(6);
        final ListNode test6 = new ListNode(2);
        test.next = test2;
        test2.next = test3;
        // test3.next = test4;
        // test4.next = test5;
        // test5.next = test6;
        partition(test, 2);
    }
}
