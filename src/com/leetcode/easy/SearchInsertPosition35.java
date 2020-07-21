package com.leetcode.easy;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        new SearchInsertPosition35().searchInsert(new int[] {1, 3, 5, 6}, 2);
    }
}
