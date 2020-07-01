package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        return getMaxDepth(root, 0);
    }

    public int getMaxDepth(TreeNode root, int curDepth) {
        if (root == null) {
            return --curDepth;
        }
        curDepth++;
        int leftDepth = getMaxDepth(root.left, curDepth);
        int rigthDepth = getMaxDepth(root.left, curDepth);
        int maxDepth = Math.max(leftDepth, rigthDepth);
        return maxDepth;
    }

    public int getMaxDepthDFS(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Queue<TreeNode> treeNode = new LinkedList<>();
        Queue<Integer> levelNode = new LinkedList<>();
        treeNode.offer(root);
        int level = 0;
        levelNode.offer(level);
        while (!treeNode.isEmpty()) {
            TreeNode curNode = treeNode.poll();
            int curLevel = levelNode.poll();
            if (curNode != null) {
                maxDepth = Math.max(maxDepth, curLevel);
                curLevel = curLevel + 1;
                treeNode.offer(curNode.left);
                levelNode.offer(curLevel);
                treeNode.offer(curNode.right);
                levelNode.offer(curLevel);
            }
        }
        return maxDepth;
    }
}
