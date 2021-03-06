package com.leetcode.medium;

// 寻找到最大值的点 即前半部分是升序 后半部分也是升序
public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (nums.length == 0) {
            return -1;
        }
        if (target == nums[minIdx]) {
            return minIdx;
        }
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {

                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        new SearchInRotatedSortedArray33().search(new int[] {0, 1, 2, 4, 5, 6, 7}, 0);
    }
}
