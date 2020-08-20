package com.leetcode.medium;

public class JumpGame55 {
    public static boolean canJump(int[] nums) {
        int end = 0;
        int maxPostions = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (end < i) {
                return false;
            }
            maxPostions = Math.max(maxPostions, nums[i] + i);
            if (i == end) {
                end = maxPostions;
            }

        }
        return maxPostions >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
    }
}
