package com.leetcode.easy;

import java.util.HashMap;

/**
 * @author lxc
 * @date 2019/12/9
 */
public class TwoSum {
    public static int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, len = nums.length; i < len - 1; i++) {
            int ret = target - nums[i];
            if (null != map.get(ret)) {
                return new int[] {map.get(ret), i};
            } else {
                map.put(nums[i], i);
            } ;
        } ;
        return new int[] {};
    };

    public static void main(String args[]) {
        twosum(new int[] {2, 7, 11, 15}, 9);
    }
}
