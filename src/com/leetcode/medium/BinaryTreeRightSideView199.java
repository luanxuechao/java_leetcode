package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> trees = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        trees.offer(root);
        while (!trees.isEmpty()) {
            int levelNum = trees.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = trees.poll();
                if (i == levelNum - 1) {
                    res.add(curNode.val);
                }
                if (curNode.left != null) {
                    trees.offer(curNode.left);
                }
                if (curNode.right != null) {
                    trees.offer(curNode.right);
                }
            }
        }
        return res;
    }
}
