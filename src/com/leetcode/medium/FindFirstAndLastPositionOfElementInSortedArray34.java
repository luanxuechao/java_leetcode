package com.leetcode.medium;

// 二分法分别找出左边界和右边界
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1, -1};
        }
        int[] res = new int[2];
        res[0] = searchIndex(nums, target, false);
        if (res[0] == nums.length || nums[res[0]] != target) {
            return new int[] {-1, -1};
        }
        res[1] = searchIndex(nums, target, true) - 1;
        return res;
    }

    public int searchIndex(int[] nums, int target, boolean isMax) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target || (isMax && nums[mid] == target)) {
                start = mid + 1;
            } else {
                end = mid;

            }
        }
        return start;
    }

    public static void main(String[] args) {
        new FindFirstAndLastPositionOfElementInSortedArray34().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
    }
}
