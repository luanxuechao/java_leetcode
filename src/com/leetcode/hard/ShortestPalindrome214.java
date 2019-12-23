package com.leetcode.hard;

/**
 * @author lxc
 * @date 2019/12/22
 */
public class ShortestPalindrome214 {
    // 超时解法 从中间开始判断 是否符合回文
    // public static String createPalindrome(String s, int left, int right) {
    // int n = s.length();
    // String firstString = s.substring(0, left);
    // String secondString = s.substring(right, n);
    // int fn = firstString.length();
    // int sn = secondString.length();
    // StringBuilder shortest = new StringBuilder();
    // boolean ismatch = true;
    // if (fn > sn) {
    // return s + s;
    // }
    // for (int i = 0; i < sn; i++) {
    // if (fn - i - 1 < 0) {
    // shortest.insert(0, secondString.substring(i, i + 1));
    // continue;
    // }
    // if (fn - i - 1 >= 0 && firstString.charAt(fn - i - 1) != secondString.charAt(i)) {
    // ismatch = false;
    // break;
    // }
    //
    // }
    // if (!ismatch) {
    // return s + s;
    // }
    // return shortest.append(s).toString();
    // };
    //
    // public static String shortestPalindrome(String s) {
    // int n = s.length();
    // if (n <= 1) {
    // return s;
    // }
    // String shortest = s + s;
    // int mid = n / 2;
    // for (int i = mid; i >= 0; i--) {
    // String newShortest = createPalindrome(s, i, i);
    // if (newShortest.length() < shortest.length()) {
    // shortest = newShortest;
    // }
    // newShortest = createPalindrome(s, i, i + 1);
    // if (newShortest.length() < shortest.length()) {
    // shortest = newShortest;
    // }
    // }
    // return shortest;
    //
    // };
    public static String shortestPalindrome(String s) {
        int i = 0, n = s.length();
        for (int j = n - 1; j >= 0; --j) {
            if (s.charAt(i) == s.charAt(j)) {
                ++i;
            }

        }
        if (i == n) {
            return s;
        }

        String rem = s.substring(i);
        String rem_rev = new StringBuilder(rem).reverse().toString();
        return rem_rev + shortestPalindrome(s.substring(0, i)) + rem;
    }

    public static void main(String[] args) {
        shortestPalindrome("aacecaaa");
    }
}
