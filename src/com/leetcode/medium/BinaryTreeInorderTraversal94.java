package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversal94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        findNode(root, result);
        System.out.print(result);
        return result;
    }

    public static List<Integer> findNode(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            findNode(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            findNode(node.right, result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreeInorderTraversal94.inorderTraversal(root);
    }
}
