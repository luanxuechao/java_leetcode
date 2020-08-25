package com.leetcode.medium;

public class UniquePaths62 {
    // 未理解起压榨解释，直接抄的代码
    // https://leetcode.wang/leetCode-62-Unique-Paths.html
    public int uniquePaths(int m, int n) {

        int[] dp = new int[m];
        // 初始化最后一列
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        // 从右向左更新所有列
        for (int i = n - 2; i >= 0; i--) {
            // 最后一行永远是 1，所以从倒数第 2 行开始
            // 从下向上更新所有行
            for (int j = m - 2; j >= 0; j--) {
                // 右边的和下边的更新当前元素
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}
