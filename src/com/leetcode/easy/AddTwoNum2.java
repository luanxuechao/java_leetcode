package com.leetcode.easy;

/**
 * @author lxc
 * @Date 2019/12/15
 */
/**
 * 链表 从个位进行加减 注意进位
 */

public class AddTwoNum2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;

        }
        if (null == l2) {
            return l1;
        }
        ListNode ret = new ListNode(0);
        ListNode current = ret;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            current.next = new ListNode(sum);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return ret.next;
    }
}
