package com.leetcode.medium;

/**
 * @author xuechaoluan
 */
// 快 慢指针

public class RemoveNthNodeFromEndofList19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(final int x) {
            this.val = x;
        }
    }

    public static ListNode removeNthFromEnd(final ListNode head, final int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        // 代表 链表长度 等于 n 相当于移除第一个
        if (fastNode == null) {
            return head.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }

    public static void main(final String[] args) {
        final ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        removeNthFromEnd(a, 2);

    }
}
