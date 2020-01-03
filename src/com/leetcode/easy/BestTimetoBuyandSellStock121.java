package com.leetcode.easy;

/**
 * @author lxc
 * @Date 2019/12/23
 */
public class BestTimetoBuyandSellStock121 {
    // 求出当前区间最小值 后面区间的最大值
    //
    //
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);

        }
        System.out.println(res);
        return res;
    };

    public static void main(String[] args) {
        maxProfit(new int[] {7, 1, 5, 3, 6, 4});
    }
}
