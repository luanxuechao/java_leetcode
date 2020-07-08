package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean hasPathSumBFS(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        queueSum.add(root.val);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                int curSum = queueSum.poll();
                if (curNode != null) {
                    if (curNode.right == null && curNode.left == null && curSum == sum) {
                        return true;
                    }
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                        queueSum.offer(curSum + curNode.left.val);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                        queueSum.offer(curSum + curNode.right.val);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasPathSumDFS(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        TreeNode cur = root;
        int curSum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                curSum += cur.val;
                stackSum.push(curSum);
                cur = cur.left;
            }
            cur = stack.pop();
            curSum = stackSum.pop();
            if (curSum == sum && cur.left == null && cur.right == null) {
                return true;
            }
            cur = cur.right;
        }
        return false;
    }
}
