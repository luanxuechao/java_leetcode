package com.leetcode.medium;

/**
 * @author lxc
 * @date 2020/1/16
 */
public class StringToInteger8 {
    public static int myAtoi(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length && Character.isWhitespace(charArray[i])) {
            i++;
        }
        boolean neg = false;
        int result = 0;
        if (i < charArray.length) {
            if (charArray[i] == '-') {
                neg = true;
                i++;
            } else if (charArray[i] == '+') {
                neg = false;
                i++;
            }
        }
        while (i < charArray.length) {
            char ch = charArray[i];
            if (Character.isDigit(ch)) {
                int update = (result * 10) + (ch - '0');
                if (result > (Integer.MAX_VALUE / 10)
                    || (result == (Integer.MAX_VALUE / 10) && ((ch - '0') > (Integer.MAX_VALUE % 10)))) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else {
                    result = update;
                }
            } else {
                break;
            }
            i++;
        }
        return neg ? -result : result;
    }

    public static void main(String Args[]) {
        myAtoi("words and 987");
    }
}
