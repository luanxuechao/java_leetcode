package com.leetcode.easy;

// 快慢指针
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                continue;
            }
            nums[i] = nums[j];
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        removeElement(new int[] {3, 2, 2, 3}, 3);
    }
}
