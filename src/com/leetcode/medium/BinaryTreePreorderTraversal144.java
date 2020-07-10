package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
        return;
    }
}
