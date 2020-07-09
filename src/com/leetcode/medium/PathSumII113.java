package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        hasPathSumHelper(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    public void hasPathSumHelper(TreeNode root, int sum, ArrayList<Integer> temp, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        if (root.left == null) {
            temp.add(root.val);
            hasPathSumHelper(root.right, sum - root.val, temp, result);
            temp.remove(temp.size() - 1);
            return;
        }
        if (root.right == null) {
            temp.add(root.val);
            hasPathSumHelper(root.left, sum - root.val, temp, result);
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        hasPathSumHelper(root.right, sum - root.val, temp, result);
        temp.remove(temp.size() - 1);

        temp.add(root.val);
        hasPathSumHelper(root.left, sum - root.val, temp, result);
        temp.remove(temp.size() - 1);
    }
}
