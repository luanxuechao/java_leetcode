package com.leetcode.easy;

import java.util.Arrays;

/**
 * @author lxc
 * @Date 2019/12/9
 */
public class ThressSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0;
        if (nums.length < 3) {
            return ret;
        }
        ret = nums[0] + nums[1] + nums[2];
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = len - 1;
            int left = i + 1;
            while (left < right) {
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
                if (Math.abs(sum - target) < Math.abs(ret - target)) {
                    ret = sum;
                }
            }
        }
        System.out.print(ret);
        return ret;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
    }
}
