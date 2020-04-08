package com.leetcode.easy;

public class MergeTwoSortedLists21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }
}
