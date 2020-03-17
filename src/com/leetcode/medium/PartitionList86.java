package com.leetcode.medium;

// 是将所有小于给定值的节点取出组成一个新的链表，此时原链表中剩余的节点的值都大于或等于给定值，只要将原链表直接接在新链表后即可
public class PartitionList86 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(final int x) {
            this.val = x;
        }
    }

    public static ListNode partition(ListNode head, final int x) {
        if (head == null) {
            return head;
        }
        ListNode h = null;
        ListNode l = null;
        ListNode hFir = null;
        ListNode lFir = null;

        while (head != null) {
            if (head.val >= x) {
                if (h == null) {
                    h = new ListNode(head.val);
                    hFir = h;
                } else {
                    h.next = new ListNode(head.val);
                    h = h.next;
                }
            }
            if (head.val < x) {
                if (l == null) {
                    l = new ListNode(head.val);
                    lFir = l;
                } else {
                    l.next = new ListNode(head.val);
                    l = l.next;
                }
            }
            head = head.next;
        }
        if (lFir == null) {
            lFir = hFir;
        } else {
            l.next = hFir;
        }

        return lFir;

        // ListNode headCopy=head;
        // ListNode h=null;
        // ListNode t=null;
        // while (headCopy!=null){
        // ListNode l = new ListNode(headCopy.val);
        // if (l.val<x){
        // l.next = h;
        // h=l;
        // }
        // else {
        // l.next = t;
        // t=l;
        // }
        // headCopy=headCopy.next;
        // }
        // head=null;
        // while (t!=null){
        // ListNode l = new ListNode(t.val);
        // l.next=head;
        // head = l;
        // t=t.next;
        // }
        // while (h!=null){
        // ListNode l = new ListNode(h.val);
        // l.next=head;
        // head = l;
        // h=h.next;
        // }
        // return head;
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
