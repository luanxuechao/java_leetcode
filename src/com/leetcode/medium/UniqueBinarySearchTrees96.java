package com.leetcode.medium;

public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return getAns(1, n);
    }

    public int getAns(int start, int end) {
        int ans = 0;
        if (start >= end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftTrees = getAns(start, i - 1);
            int rightTrees = getAns(i + 1, end);
            ans += leftTrees * rightTrees;

        }
        return ans;
    }

    // 动态规划解法
    public int nums(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int root = 1; root <= i; i++) {
                dp[i] += dp[root - 1] * dp[i - root];
            }
        }
        return dp[n];
    }
}
