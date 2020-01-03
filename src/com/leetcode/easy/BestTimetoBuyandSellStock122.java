package com.leetcode.easy;

/**
 * @author lxc
 * @Date 2019/12/23
 */
public class BestTimetoBuyandSellStock122 {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        maxProfit(new int[] {1, 2, 3, 4, 5});
    }
}
