package com.leetcode.medium;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (root.left != null) {
                int max = getMaxBST(root.left);
                if (root.val <= max) {
                    return false;
                }
            }
        } else {
            return false;
        }
        if (isValidBST(root.right)) {
            if (root.right != null) {
                int min = getMinBST(root.right);
                if (root.val >= min) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    private int getMinBST(TreeNode root) {
        int min = root.val;
        while (root != null) {
            if (root.val <= min) {
                min = root.val;
            }
            root = root.left;
        }
        return min;
    }

    private int getMaxBST(TreeNode root) {
        int max = root.val;
        while (root != null) {
            if (root.val >= max) {
                max = root.val;
            }
            root = root.right;
        }
        return max;
    }

    // 动态规划求解: 从根节点DFS, 用区间求解
    public boolean isValidDPBST(TreeNode root) {
        long maxValue = (long)Integer.MAX_VALUE + 1;
        long minValue = (long)Integer.MIN_VALUE - 1;
        return getAns(root, maxValue, minValue);
    }

    private boolean getAns(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue) {
            return false;
        }
        if (root.val <= minValue) {
            return false;
        }
        return getAns(root.left, root.val, minValue) && getAns(root.right, maxValue, root.val);
    }
}
