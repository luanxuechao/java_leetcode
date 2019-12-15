package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lxc
 * @Date 2019/12/15
 */
public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        Stack<Integer> s1 = new Stack<Integer>();
        List<Integer> rets = new ArrayList<Integer>();
        int carry = 0;
        for (int i = A.length - 1; i > -1; i--) {
            int sum = A[i] + K % 10 + carry;
            carry = sum / 10;
            s1.push(sum % 10);
            K = K / 10;
        }
        while (K != 0 || carry != 0) {
            int sum = K % 10 + carry;
            K = K / 10;
            carry = sum / 10;
            s1.push(sum % 10);
        }
        while (!s1.isEmpty()) {
            rets.add(s1.pop());
        }
        return rets;
    }

    public static void main(String[] args) {
        addToArrayForm(new int[] {7}, 993);
    }
}
