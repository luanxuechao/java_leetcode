package com.leetcode.medium;

public class ContainerWithMostWater11 {
    public static int maxArea(final int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start != end) {
            final int currentArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(currentArea, maxArea);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;
    }

    public static void main(final String[] args) {
        final int[] a = new int[] {2, 3, 4, 5, 18, 17, 6};
        maxArea(a);
    }
}
