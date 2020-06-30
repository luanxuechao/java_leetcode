package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getLevelOrder(root, result, 0);
        return result;
    }

    public void getLevelOrder(TreeNode root, List<List<Integer>> result, int index) {
        if (root == null) {
            return;
        }
        List<Integer> currentArray = null;
        if (result.size() > index) {
            currentArray = result.get(index);
        }
        if (currentArray == null) {
            currentArray = new ArrayList<Integer>();
            result.add(currentArray);
        }
        currentArray.add(root.val);
        getLevelOrder(root.left, result, index + 1);
        getLevelOrder(root.right, result, index + 1);
        return;
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> treeNode = new LinkedList<>();
        Queue<Integer> nodeLevel = new LinkedList<>();
        treeNode.offer(root);
        int level = 0;
        nodeLevel.offer(level);
        while (!treeNode.isEmpty()) {
            TreeNode curNode = treeNode.poll();
            int curLevel = nodeLevel.poll();
            if (curNode != null) {
                if (ans.size() <= curLevel) {
                    ans.add(new ArrayList<>());
                }
                ans.get(curLevel).add(curNode.val);
                level = curLevel + 1;
                treeNode.offer(curNode.left);
                nodeLevel.offer(level);
                treeNode.offer(curNode.right);
                nodeLevel.offer(level);
            }
        }
        return ans;
    }
}
