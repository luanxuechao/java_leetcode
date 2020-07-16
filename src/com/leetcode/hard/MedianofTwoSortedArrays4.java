package com.leetcode.hard;

import java.util.Stack;

public class MedianofTwoSortedArrays4 {
    // 通过寻找中点解决
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength == 0) {
            return 0;
        }
        int midLength = (int)Math.floor(totalLength / 2);
        int firstPoint = 0;
        int sencondPoint = 0;
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        while (sencondPoint + firstPoint <= midLength) {
            if (firstPoint > nums1.length - 1) {
                stack.push(nums2[sencondPoint]);
                curNum = nums2[sencondPoint];
                sencondPoint++;
                continue;
            }
            if (sencondPoint > nums2.length - 1) {
                stack.push(nums1[firstPoint]);
                curNum = nums1[firstPoint];
                firstPoint++;
                continue;
            }
            if (nums1[firstPoint] > nums2[sencondPoint]) {
                stack.push(nums2[sencondPoint]);
                curNum = nums2[sencondPoint];
                sencondPoint++;
            } else {
                stack.push(nums1[firstPoint]);
                curNum = nums1[firstPoint];
                firstPoint++;
            }

        }
        if (totalLength % 2 == 0) {
            return (stack.pop() + stack.pop()) / 2.0;
        } else {
            return curNum;
        }
    }
}
