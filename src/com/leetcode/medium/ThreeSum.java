package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lxc
 * @Date 2019/12/9
 */
/**
 * 通过两个指针找出和为target
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rets = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return rets;
        }
        for (int i = 0, len = nums.length; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int right = len - 1;
            int left = i + 1;
            while (left < right) {
                int sum = nums[right] + nums[left];
                if (sum == target) {
                    rets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
            }
        }
        System.out.print(rets);
        return rets;
    }

    public static void main(String args[]) {
        threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    }
}
