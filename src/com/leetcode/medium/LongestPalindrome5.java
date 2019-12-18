package com.leetcode.medium;

/**
 * @author lxc
 * @Date 2019/12/18
 */
/**
 * 把每次开始的字符串当做中间字符串,用两个指针比较
 */
public class LongestPalindrome5 {
    public static String findPalindrome(String s, int left, int right) {
        int n = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        String longest = "";

        String str;
        for (int i = 0; i < n - 1; i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()) {
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
