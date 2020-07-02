package com.leetcode.medium;

import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start,
        int p_end) {
        if (p_start == p_end) {
            return null;
        }
        int node_val = postorder[p_end - 1];
        TreeNode node = new TreeNode(node_val);
        int i_node_index = 0;
        for (int i = i_start; i <= i_end; i++) {
            if (inorder[i] == node_val) {
                i_node_index = i;
                break;
            }
        }
        int rightNum = i_node_index - i_start;
        node.left = buildTreeHelper(inorder, i_start, i_node_index, postorder, p_start, p_start + rightNum);
        node.right = buildTreeHelper(inorder, i_node_index + 1, i_end, postorder, p_start + rightNum, p_end - 1);
        return node;
    }

    public static TreeNode buildTreeStack(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<>();
        int pre = postorder.length - 1;
        int in = inorder.length - 1;;
        TreeNode curRoot = new TreeNode(postorder[pre]);
        TreeNode root = curRoot;
        roots.push(curRoot);
        pre--;
        while (pre > -1) {
            if (curRoot.val == inorder[in]) {
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in--;
                }
                curRoot.left = new TreeNode(postorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
            } else {
                TreeNode node = new TreeNode(postorder[pre]);
                curRoot.right = node;
                curRoot = node;
                roots.push(curRoot);
            }
            pre--;
        }
        return root;
    }

    public static void main(String[] args) {
        buildTreeStack(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
    }

}
