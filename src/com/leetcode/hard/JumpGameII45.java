package com.leetcode.hard;

// 贪心算法 局部最优 到全局最优
public class JumpGameII45 {
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        jump(new int[] {2, 3, 1, 1, 4});
    }
}
