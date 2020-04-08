package com.leetcode.hard;

public class MergekSortedLists23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        while (currentNode1 != null || currentNode2 != null) {
            if (currentNode1 == null) {
                currentNode.next = currentNode2;
                break;
            }
            if (currentNode2 == null) {
                currentNode.next = currentNode1;
                break;
            }
            if (currentNode1.val > currentNode2.val) {
                currentNode.next = new ListNode(currentNode2.val);
                currentNode2 = currentNode2.next;
            } else {
                currentNode.next = new ListNode(currentNode1.val);
                currentNode1 = currentNode1.next;
            }
            currentNode = currentNode.next;
        }
        return result.next;
    }
}
