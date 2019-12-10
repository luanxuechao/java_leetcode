package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lxc
 * @Date 2019/12/10
 */

/**
 * 解法与threeSum 没有加一次循环
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return ret;
        }
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (target == sum) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    if (target > sum) {
                        left++;
                    }
                    if (target < sum) {
                        right--;
                    }
                }
            }
        }
        System.out.print(ret);
        return ret;
    }

    public static void main(String[] args) {

        fourSum(new int[] {0, 0, 0, 0}, 0);
    }
}
