package com.leetcode.easy;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, sum);
    }

    public boolean hasPathSumHelper(TreeNode root, int sum) {
        int nextSum = sum - root.val;
        if (nextSum == 0 && root.right == null && root.left == null) {
            return true;
        }
        if (nextSum != 0 && root.right == null && root.left == null) {
            return false;
        }
        if (root.left == null) {
            return hasPathSumHelper(root.right, nextSum);
        }
        if (root.right == null) {
            return hasPathSumHelper(root.left, nextSum);
        }
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}
