package com.leetcode.hard;

public class TrappingRainWater42 {

    // public static int trap(final int[] height) {
    // int start = 0;
    // int trapCount = 0;
    // int len = height.length;
    // if (height.length == 0) {
    // return trapCount;
    // }
    // while (start < len && height[start] == 0) {
    // start++;
    // }
    // int end = start + 1;
    // while (end < len && start < len) {
    // if (height[start] > height[end] && end < len - 1) {
    // end++;
    // continue;
    // } else if (height[start] > height[end] && end == len - 1) {
    // start++;
    // end = start + 1;
    // continue;
    // }
    // int currentTrap = 0;
    // for (int i = start + 1; i < end; i++) {
    // currentTrap += height[i];
    // }
    // if (end - start == 1 && start != 0 && height[start] != height[start - 1]) {
    // trapCount += Math.abs(height[start] - height[end]);
    // } else {
    // trapCount += Math.min(height[start], height[end]) * (end - start - 1) - currentTrap;
    // }
    //
    // start = end;
    // end++;
    // }
    // return trapCount;
    // }
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[] {0, 7, 1, 4, 6};
        // trap(a);
    }
}
