package com.leetcode.easy;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private static TreeNode sortedArrayToBSTHelper(int nums[], int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, start, mid);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        new ConvertSortedArraytoBinarySearchTree108().sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
    }
}
