package com.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses32 {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(')
                stack.push(j);
            else {
                if (stack.isEmpty())
                    left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, j - left);
                    else
                        max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
        // int result = 0;
        // if (s.length() == 1) {
        // return result;
        // }
        // Map<String, String> map = new HashMap<String, String>();
        // Stack<String> stack = new Stack<String>();
        // map.put("(", ")");
        // int count = 0;
        // int len = s.length();
        // for (int i = 0; i < len; i++) {
        // String el = s.substring(i, i + 1);
        // if (map.get(el) != null || stack.size() == 0) {
        // stack.push(map.get(el));
        // } else {
        // String currentEl = stack.pop();
        // if (el.equals(currentEl)) {
        // result = result + 2;
        // } else {
        // stack.push(currentEl);
        // stack.push(map.get(el));
        // }
        // }
        // }
        // return result;
    }

    public static void main(String[] args) {
        longestValidParentheses("()(())");
    }
}
