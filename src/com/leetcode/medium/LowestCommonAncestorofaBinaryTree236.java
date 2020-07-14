package com.leetcode.medium;

public class LowestCommonAncestorofaBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean right = include(root.right, p.val, q.val);
        boolean left = include(root.left, p.val, q.val);
        if (right && left) {
            return root;
        }
        if (right) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val == q.val || root.val == p.val && (right || left)) {
            return root;
        }
        return lowestCommonAncestor(root.left, p, q);
    }

    public static boolean include(TreeNode root, int p, int q) {
        if (root == null) {
            return false;
        }
        if (root.val == q || root.val == p) {
            return true;
        }
        return include(root.right, p, q) || include(root.left, p, q);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(0);
        node.right = new TreeNode(4);
        System.out.print(include(node, 5, 4));
    }
}
