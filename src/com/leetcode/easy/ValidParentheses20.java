package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public static boolean isValid(final String s) {

        final Map<String, String> map = new HashMap<String, String>();
        final Stack<String> stack = new Stack<String>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        if (s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            final String el = s.substring(i, 1 + i);
            if (map.get(el) != null) {
                stack.push(map.get(el));
            } else {
                if (stack.size() == 0 || !el.equals(stack.pop())) {
                    return false;
                }
            }

        }
        return stack.size() == 0;
    }

    public static void main(final String[] args) {
        System.out.print(isValid("{[]}"));
    }
}
