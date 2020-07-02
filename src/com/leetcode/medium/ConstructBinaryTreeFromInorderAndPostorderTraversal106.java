package com.leetcode.medium;

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
}
