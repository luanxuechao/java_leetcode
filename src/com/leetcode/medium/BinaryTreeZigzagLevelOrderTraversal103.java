package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        int nextIndex = index + 1;
        if (nextIndex % 2 == 1) {
            currentArray.add(root.val);
        } else {
            currentArray.add(0, root.val);
        }

        getLevelOrder(root.left, result, nextIndex);
        getLevelOrder(root.right, result, nextIndex);
        return;
    }

    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int level = 0;
        Queue<Integer> levelNode = new LinkedList<>();
        levelNode.offer(level);
        while (!treeNodes.isEmpty()) {
            TreeNode curNode = treeNodes.poll();
            int curLevel = levelNode.poll();
            if (curNode != null) {
                if (result.size() <= curLevel) {
                    result.add(new ArrayList<>());
                }
                if ((curLevel % 2) == 0) {
                    result.get(curLevel).add(curNode.val); // 添加到末尾
                } else {
                    result.get(curLevel).add(0, curNode.val); // 添加到头部
                }
                level = curLevel + 1;
                treeNodes.offer(curNode.left);
                levelNode.offer(level);
                treeNodes.offer(curNode.right);
                levelNode.offer(level);
            }
        }
        return result;
    }
}
