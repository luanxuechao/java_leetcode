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
}
