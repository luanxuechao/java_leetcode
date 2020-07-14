package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> trees = new Stack<>();
        Stack<String> sStr = new Stack<String>();
        trees.push(root);
        TreeNode cur = root;
        sStr.push("");
        while (!trees.isEmpty()) {
            TreeNode curNode = trees.pop();
            String curStr = sStr.pop();

            if (curNode.left == null && curNode.right == null)
                result.add(curStr + curNode.val);
            if (curNode.left != null) {
                trees.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                trees.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return result;
    }
}
