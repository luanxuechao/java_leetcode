package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxc
 * @Date 2019/12/15
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        List<Integer> s = new ArrayList<Integer>();
        int carry = 0;
        int j = 0;
        int i = 0;
        for (i = a.length() - 1, j = b.length() - 1; i > -1 && j > -1; j--, i--) {
            Integer val1 = Integer.valueOf(a.substring(i, i + 1));
            Integer val2 = Integer.valueOf(b.substring(j, j + 1));
            int sum = val1 + val2 + carry;
            carry = sum / 2;
            s.add(sum % 2);
        }
        while (j > -1) {
            int sum = Integer.valueOf(b.substring(j, j + 1)) + carry;
            carry = sum / 2;
            s.add(sum % 2);
            j--;
        }
        while (i > -1) {
            int sum = Integer.valueOf(a.substring(i, i + 1)) + carry;
            carry = sum / 2;
            s.add(sum % 2);
            i--;
        }
        if (carry > 0) {
            s.add(carry);
        }
        String ret = "";
        for (int k = s.size() - 1; k > -1; k--) {
            ret += Integer.toString((s.get(k)));
        }

        return ret;

    }

    public static void main(String[] args) {
        addBinary("11", "1");
    }
}
