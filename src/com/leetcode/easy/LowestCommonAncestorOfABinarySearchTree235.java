package com.leetcode.easy;

public class LowestCommonAncestorOfABinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val == min) {
            return root;
        }
        if (root.val == max) {
            return root;
        }
        if (root.val > min && max > root.val) {
            return root;
        }
        if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
        /// while ((root.val - p.val) * (root.val - q.val) > 0)
        // root = p.val < root.val ? root.left : root.right;
        // return root;
    }
}
