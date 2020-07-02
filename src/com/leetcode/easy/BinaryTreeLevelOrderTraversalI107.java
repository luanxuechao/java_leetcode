package com.leetcode.easy;

import java.util.*;

public class BinaryTreeLevelOrderTraversalI107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrderBottomHelper(root, result, 0);
        Collections.reverse(result);
        return result;
    }

    private void levelOrderBottomHelper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(level, new ArrayList<Integer>());
        }
        List<Integer> curArray = result.get(level);
        curArray.add(root.val);

        levelOrderBottomHelper(root.left, result, level + 1);
        levelOrderBottomHelper(root.right, result, level + 1);
        return;
    }

    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    subList.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if (subList.size() > 0) {
                ans.add(0, subList);
            }
        }
        return ans;
    }
}
