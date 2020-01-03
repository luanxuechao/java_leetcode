package com.leetcode.easy;

/**
 * @author lxc
 * @date 2020/1/3
 */
public class ReverseInteger7 {

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int n = x;
        int result = 0;
        while (n != 0) {
            int pop = n % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            if (n == -1) {
                result = (result * 10 + n);
                break;
            }
            result = result * 10 + pop;
            n = n / 10 - pop / 10;
        }
        System.out.print(result);
        return result;
    }

    public static void main(String args[]) {
        reverse(-132);
    }
}
