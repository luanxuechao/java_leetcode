package com.leetcode.hard;

public class RegularExpressionMatching10 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        // 只有长度大于 2 的时候，才考虑 *
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 两种情况
            // pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
            // pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        new RegularExpressionMatching10().isMatch("mississippi", "mis*is*p*.");
    }
}
