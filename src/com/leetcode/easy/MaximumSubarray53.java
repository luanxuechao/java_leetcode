package com.leetcode.easy;

/**
 * @author lxc
 * @Date 2019/12/23
 */

// 算出当前子数组最大sum,依次计算得出最大sum
public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int n = 1; n < nums.length; n++) {
            currentSum = Math.max(nums[n], nums[n] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
