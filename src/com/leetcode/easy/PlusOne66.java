package com.leetcode.easy;

/**
 * @author lxc
 * @Date 2019/12/15
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int[] rets = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            rets[i] = sum % 10;
        }
        if (carry > 0) {
            rets = new int[rets.length + 1];
            rets[0] = carry;
        }
        return rets;
    }
}
