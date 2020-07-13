package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallest230 {
    public int kthSmallest(TreeNode root, int k) {
        return smallestHelper(root, k);
    }

    public static int smallestHelper(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                res.add(cur.val);
                if (res.size() == k) {
                    break;
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.right;
                continue;
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            cur = cur.left;
        }
        return res.get(k - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        smallestHelper(node, 1);
    }
}
