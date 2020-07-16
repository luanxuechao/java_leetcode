package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> trees = new LinkedList<>();
        trees.offer(root);
        List<Integer> res = new LinkedList<Integer>();
        while (!trees.isEmpty()) {
            int levelNum = trees.size();
            List<String> currStr = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = trees.poll();
                if (curNode != null) {
                    currStr.add(String.valueOf(curNode.val));
                    trees.offer(curNode.left);
                    trees.offer(curNode.right);
                } else {
                    res.add(null);
                }
            }

        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] preStr = data.substring(1, data.length() - 1).split(",");
        Integer[] bfsOrder = new Integer[preStr.length];
        for (int i = 0; i < preStr.length; i++) {
            if (preStr[i].trim().equals("null")) {
                bfsOrder[i] = null;
            } else {
                bfsOrder[i] = Integer.parseInt(preStr[i].trim());
            }
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(bfsOrder[0]);
        int cur = 1;// 通过 cur 指针依次给节点赋值
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (bfsOrder[cur] != null) {
                curNode.left = new TreeNode(bfsOrder[cur]);
                queue.add(curNode.left);
            }
            cur++;
            if (bfsOrder[cur] != null) {
                curNode.right = new TreeNode(bfsOrder[cur]);
                queue.add(curNode.right);
            }
            cur++;
        }
        return root;
    }
}
