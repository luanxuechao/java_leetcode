package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        nodes.offer(root);
        numbers.offer(root.val);
        while (!nodes.isEmpty()) {
            int levelNums = nodes.size();
            for (int i = 0; i < levelNums; i++) {
                TreeNode curNode = nodes.poll();
                Integer curNumber = numbers.poll();
                if (curNode.left == null && curNode.right == null) {
                    sum += curNumber;
                    continue;
                }
                int curLevelNums = curNumber * 10 + curNode.val;
                if (curNode.left != null) {
                    nodes.offer(curNode.left);
                    numbers.offer(curLevelNums);
                }
                if (curNode.right != null) {
                    nodes.offer(curNode.right);
                    numbers.offer(curLevelNums);
                }
            }

        }
        return sum;
    }
}
