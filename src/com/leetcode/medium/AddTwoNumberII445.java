package com.leetcode.medium;

import java.util.Stack;

/**
 * @author lxc
 * @Date 2019/12/15
 */
public class AddTwoNumberII445 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        if (!s2.isEmpty()) {
            s1 = s2;
        }
        while (!s1.isEmpty()) {
            int sum = s1.pop() + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        ListNode ret = new ListNode(0);
        ListNode current = ret;
        while (!s3.isEmpty()) {
            if (carry > 0) {
                current.next = new ListNode(carry);
                carry = 0;
                current = current.next;
                continue;
            }
            current.next = new ListNode(s3.pop());
            current = current.next;
        }
        return ret.next;
    }
}
