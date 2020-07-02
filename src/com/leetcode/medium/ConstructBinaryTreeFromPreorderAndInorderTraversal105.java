package com.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    // Test case not allowed
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return node;
        }
        int leftTreeInNumIndex = findIndexOf(preorder[0], inorder);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftTreeInNumIndex);
        int leftTreePreNumIndex = 0;
        if (leftInorder.length != 0) {
            leftTreePreNumIndex = findIndexOf(leftInorder[leftInorder.length - 1], preorder);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftTreePreNumIndex + 1);
            node.left = buildTree(leftPreorder, leftInorder);
        }
        int[] rightInorder = Arrays.copyOfRange(inorder, leftTreeInNumIndex + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftTreePreNumIndex + 1, preorder.length);
        node.right = buildTree(rightPreorder, rightInorder);
        return node;
    }

    static int findIndexOf(int V, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (V == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // answers
    public static TreeNode buildTreeT(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start,
        int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        // 在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        // 递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        // 递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    // stack
    public static TreeNode buildTreeStack(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<>();
        int pre = 0;
        int in = 0;
        TreeNode curRoot = new TreeNode(preorder[pre]);
        TreeNode root = curRoot;
        pre++;
        roots.push(curRoot);
        while (pre < preorder.length) {
            if (curRoot.val == inorder[in]) {
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in++;
                }
                curRoot.right = new TreeNode(preorder[pre]);
                curRoot = curRoot.right;
                roots.push(curRoot);
                pre++;

            } else {
                curRoot.left = new TreeNode(preorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                pre++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = buildTreeStack(new int[] {3, 9, 20, 15, 7}, new int[] {20, 9, 15, 3, 7});
    }
}
