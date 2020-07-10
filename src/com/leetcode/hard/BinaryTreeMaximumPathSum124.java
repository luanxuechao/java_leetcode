package com.leetcode.hard;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaximumPathSum124 {

    // public int maxPathSum(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int maxSum = Integer.MIN_VALUE;
    // TreeNode curNode = root;
    // Queue<TreeNode> nodes = new LinkedList<>();
    // nodes.offer(root);
    // while (!nodes.isEmpty()) {
    // int levelNum = nodes.size();
    // for (int i = 0; i < levelNum; i++) {
    // curNode = nodes.poll();
    // int currentSum = getTreeSum(curNode);
    // maxSum = Math.max(curNode.val, maxSum);
    // maxSum = Math.max(currentSum, maxSum);
    // if (curNode.left != null) {
    // int leftSum = getTreeSum(curNode.left);
    // nodes.offer(curNode.left);
    // maxSum = Math.max(maxSum, leftSum);
    // }
    // if (curNode.right != null) {
    // nodes.offer(curNode.right);
    // int rightSum = getTreeSum(curNode.right);
    // maxSum = Math.max(maxSum, rightSum);
    // }
    // }
    //
    // }
    // return maxSum;
    // }
    //
    // int getTreeSum(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // int sum = root.val + getTreeSum(root.left) + getTreeSum(root.right);
    // sum = Math.max(sum, root.val + getTreeSum(root.left));
    // sum = Math.max(sum, root.val + getTreeSum(root.right));
    // return sum;
    // }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return this.max;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // 求的过程中考虑包含当前根节点的最大路径
        this.max = Math.max(this.max, root.val + left + right);

        // 只返回包含当前根节点和左子树或者右子树的路径
        return root.val + Math.max(left, right);
    }
}
