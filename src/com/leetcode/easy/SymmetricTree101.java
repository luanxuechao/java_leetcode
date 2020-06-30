package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    // DFS(深度优先搜索)
    public boolean isSymmetricDFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode currLeft = root.left;
        TreeNode currRight = root.right;
        while (currLeft != null || !leftStack.isEmpty() || currRight != null || !rightStack.isEmpty()) {
            while (currLeft != null) {
                leftStack.push(currLeft);
                currLeft = currLeft.left;
            }
            while (currRight != null) {
                rightStack.push(currRight);
                currRight = currRight.right;
            }
            if (leftStack.size() != rightStack.size()) {
                return false;
            }
            currLeft = leftStack.pop();
            currRight = rightStack.pop();
            if (currLeft.val != currRight.val) {
                return false;
            }
            currLeft = currLeft.right;
            currRight = currRight.left;
        }
        return true;
    }

    // BFS(广度优先搜索)
    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftTree = leftQueue.poll();
            TreeNode rightTree = rightQueue.poll();
            if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
                return false;
            }
            if (rightTree != null && leftTree != null) {
                if (rightTree.val != leftTree.val) {
                    return false;
                }
                leftQueue.offer(leftTree.left);
                leftQueue.offer(leftTree.right);

                rightQueue.offer(rightTree.right);
                rightQueue.offer(rightTree.left);
            }

        }
        if (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            return false;
        }
        return true;
    }
}
