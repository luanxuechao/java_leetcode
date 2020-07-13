package com.leetcode.easy;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
