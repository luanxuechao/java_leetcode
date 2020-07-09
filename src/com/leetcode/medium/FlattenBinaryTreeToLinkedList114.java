package com.leetcode.medium;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> trees = new Stack<>();
        TreeNode curNode = root;
        TreeNode pre = null;
        while (curNode != null || !trees.isEmpty()) {
            while (curNode.right != null) {
                trees.push(curNode);
                curNode = curNode.right;
                continue;
            }
            curNode = trees.peek();
            if (curNode.left == null || curNode.left == pre) {
                trees.pop();
                curNode.right = pre;
                curNode.left = null;
                pre = curNode;
                curNode = null;
            } else {
                curNode = curNode.left;
            }
        }
    }
}
